package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;


import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.presenter.BrowseAPresenter;
import com.szachnowicz.simplyshopapp.repository.repo.OrderRepo;
import com.szachnowicz.simplyshopapp.views.recyclerView.adapter.ShopProductAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BrowseActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @BindView(R.id.search_view_product)
    SearchView searchView;

    @BindView(R.id.searchRecyclerView)
    RecyclerView recyclerView;

    private BrowseAPresenter presenter = new BrowseAPresenter();
    private ShopProductAdapter productAdapter;
    private Order currnetOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        ButterKnife.bind(this);
        creatRecyclerView(recyclerView);
        searchView.setOnQueryTextListener(this);
        getCurrentOrder();

    }

    private void getCurrentOrder() {
        // this is hardcoed, bc there is no users in app;
        new OrderRepo(getApplicationContext()).getCurrentOrder(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(order -> {
                    if (!order.isCompleted())
                        setCurrnetOrder(order);
                    productAdapter.setCurrnetOrder(order);
                });

    }

    private void creatRecyclerView(RecyclerView recyclerView) {

        productAdapter = new ShopProductAdapter(getApplicationContext(), new ArrayList<ImgProduct>());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.getFakeProduct()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(abstractProduct -> {
                    productAdapter.addNewProduct(abstractProduct);
                    presenter.addNewProduct(abstractProduct);
                });

    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String searchText) {
        List<ImgProduct> filteredList = new ArrayList<>();
        searchText = searchText.toLowerCase();
        if (searchText.equals("")) {
            productAdapter.setProductsList(presenter.getProductsList());
            return true;
        }

        for (ImgProduct product : presenter.getProductsList()) {

            String name = product.getName().toLowerCase();

            if (name.startsWith(searchText) ||
                    name.endsWith(searchText) ||
                    name.contains(searchText))
                filteredList.add(product);
        }
        productAdapter.setProductsList(filteredList);
        return true;
    }

    public void setCurrnetOrder(Order currnetOrder) {
        this.currnetOrder = currnetOrder;
    }
}
