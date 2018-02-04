package com.szachnowicz.simplyshopapp.repository.repo;

import android.content.Context;
import android.widget.Toast;

import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.repository.ProductDatabase;

import java.util.List;

import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sebastian on 2018-02-03.
 */

public class ImgProductRepo {
    private final Context context;

    public ImgProductRepo(Context context) {
        this.context = context;
    }

    public Observable<ImgProduct> getAllRecords() {
        return Observable.create(subscriber -> {
            List<ImgProduct> allProducts = ProductDatabase.getInstance(context).productDao().getAllProducts();
            if (allProducts != null) {
                for (ImgProduct allProduct : allProducts) {
                    subscriber.onNext(allProduct);

                }
            }
            subscriber.onComplete();
        });

    }


    public void addRecord(ImgProduct imgProduct) {
        Observable.fromCallable(() -> {
            ProductDatabase.getInstance(context).productDao().addRecord(imgProduct);
            return true;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                });
    }


}
