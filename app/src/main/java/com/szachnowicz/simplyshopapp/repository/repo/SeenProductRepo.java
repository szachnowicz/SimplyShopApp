package com.szachnowicz.simplyshopapp.repository.repo;

import android.content.Context;

import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.repository.ProductDatabase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sebastian on 2018-02-03.
 */

public class SeenProductRepo {
    private final Context context;

    public SeenProductRepo(Context context) {
        this.context = context;
    }


    public Observable<SeenProduct> getAllRecords() {
        return Observable.create(subscriber -> {
            List<SeenProduct> allProducts = ProductDatabase.getInstance(context).seenProductDao().getAllProducts();
            if (allProducts != null) {
                for (SeenProduct product : allProducts) {
                    subscriber.onNext(product);
                }
            }
            subscriber.onComplete();
        });
    }


    public void addRecord(SeenProduct product) {
        Observable.fromCallable(() -> {
            ProductDatabase.getInstance(context).seenProductDao().addRecord(product);
            return true;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                });
    }

}
