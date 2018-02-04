package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.OrderItem;
import com.szachnowicz.simplyshopapp.repository.repo.OrderItemRepo;
import com.szachnowicz.simplyshopapp.repository.repo.OrderRepo;
import com.szachnowicz.simplyshopapp.views.listView.CartAdpater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CartActivity extends AppCompatActivity {
    @BindView(R.id.cartListView)
    ListView listView;
    private CartAdpater cartAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        setUpAdpter();
        getCurrentOrder();
    }

    private void setUpAdpter() {

        cartAdpater = new CartAdpater(getApplicationContext(), new ArrayList<>());
        listView.setAdapter(cartAdpater);


    }


    private void getCurrentOrder() {
        // this is hardcoed, becouse there is no users in app;
        new OrderRepo(getApplicationContext()).getCurrentOrder(0)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(order -> {
                    if (!order.isCompleted()) {
                        getAndDisplayOrderTimes(order);
                    }


                });

    }

    private void getAndDisplayOrderTimes(Order order) {
        new OrderItemRepo(getApplicationContext()).getAllForOrder(order)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(orderItem -> {
                    cartAdpater.addToList(orderItem);
                });

    }

}
