package com.szachnowicz.simplyshopapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;


import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.AbstractProduct;
import com.szachnowicz.simplyshopapp.services.ProductService;
import com.szachnowicz.simplyshopapp.views.recyclerView.adapter.ShopItemAdapter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BrowseActivity extends AppCompatActivity {

    @BindView(R.id.search_view_product)
    SearchView searchView;

    @BindView(R.id.searchRecyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        ButterKnife.bind(this);
        creatRecyclerView(recyclerView);

    }

    private void creatRecyclerView(RecyclerView recyclerView) {
        ArrayList<AbstractProduct> productsList = new ArrayList<>();
        productsList.add(ProductService.getRandomProduct());
        productsList.add(ProductService.getRandomProduct());
        productsList.add(ProductService.getRandomProduct());


        ShopItemAdapter shopItemAdapter = new ShopItemAdapter(getApplicationContext(), productsList);
        recyclerView.setAdapter(shopItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getFakeProduct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(shopItemAdapter::addNewProduct);

    }

    public Observable<AbstractProduct> getFakeProduct() {
        return Observable
                .intervalRange(0, 20, 500, 500, TimeUnit.MILLISECONDS)
                .map(elemnet -> ProductService.getRandomProduct());

    }
}
