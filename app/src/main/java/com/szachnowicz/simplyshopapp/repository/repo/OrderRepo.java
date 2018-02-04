package com.szachnowicz.simplyshopapp.repository.repo;

import android.content.Context;

import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.repository.ProductDatabase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sebastian on 2018-02-04.
 */

public class OrderRepo implements ICrud<Order> {
    private final Context context;

    public OrderRepo(Context context) {
        this.context = context;
    }

    public Observable<Order> getCurrentOrder(long userId) {
        return Observable.create(subscribe -> {
            final List<Order> orders =
                    ProductDatabase.getInstance(context)
                            .orderDao()
                            .getUnComplitedOrderForUser(userId);

            if (orders == null || orders.isEmpty()) return;

            final Order order = orders.get(0);
            subscribe.onNext(order);
            subscribe.onComplete();
        });
    }


    @Override
    public Observable<Order> getAll() {
        return Observable.create(subscriber -> {
            List<Order> allOrders = ProductDatabase.getInstance(context).orderDao().getAllOrders();
            if (allOrders != null && !allOrders.isEmpty()) {
                for (Order order : allOrders) {
                    subscriber.onNext(order);
                }
            }
            subscriber.onComplete();
        });
    }

    @Override
    public void addRecord(Order order) {
        Observable.fromCallable(() -> {
            ProductDatabase.getInstance(context).orderDao().addRecord(order);
            return true;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                });

    }

    @Override
    public void removeRecord(Order order) {

    }
}
