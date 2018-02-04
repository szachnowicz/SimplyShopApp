package com.szachnowicz.simplyshopapp.repository.repo;

import android.content.Context;
import android.widget.Toast;

import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.OrderItem;
import com.szachnowicz.simplyshopapp.repository.ProductDatabase;

import java.util.List;

import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sebastian on 2018-02-04.
 */

public class OrderItemRepo implements ICrud<OrderItem> {
    private final Context context;

    public OrderItemRepo(Context context) {
        this.context = context;
    }

    @Override
    public Observable<OrderItem> getAll() {
        return Observable.create(subscriber -> {
            List<OrderItem> orderItemList = ProductDatabase.getInstance(context).orderItemDao().getAll();

            if (orderItemList == null || orderItemList.isEmpty()) return;
            for (OrderItem orderItem : orderItemList) {
                subscriber.onNext(orderItem);
            }
            subscriber.onComplete();
        });
    }


    public Observable<OrderItem> getAllForOrder(Order order) {

        return Observable.create(subscriber -> {
            List<OrderItem> orderItemList = ProductDatabase.getInstance(context).orderItemDao().getAllOrder(order.getId());

            if (orderItemList == null || orderItemList.isEmpty()) return;
                for (OrderItem orderItem : orderItemList) {
                    subscriber.onNext(orderItem);
                }
            subscriber.onComplete();
        });

    }


    @Override
    public void addRecord(OrderItem orderItem) {

        Observable.fromCallable(() -> {
            ProductDatabase.getInstance(context).orderItemDao().addRecord(orderItem);
            return true;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    Toasty.success(context, context.getString(R.string.addedToCart), Toast.LENGTH_SHORT).show();
                });

    }

    @Override
    public void removeRecord(OrderItem orderItem) {
        Observable.fromCallable(() -> {
            ProductDatabase.getInstance(context).orderItemDao().delete(orderItem);
            return true;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    Toasty.warning(context, context.getString(R.string.itemRemoved), Toast.LENGTH_SHORT).show();
                });


    }
}
