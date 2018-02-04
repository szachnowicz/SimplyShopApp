package com.szachnowicz.simplyshopapp.presenter;

import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Sebastian on 2018-02-02.
 */

public class BrowseAPresenter {

    private List<ImgProduct> productsList = new ArrayList<>();


    public BrowseAPresenter() {

    }

    public Observable<ImgProduct> getFakeProduct() {
        return Observable
                .intervalRange(0, 50, 750, 750, TimeUnit.MILLISECONDS)
                .map(elemnet -> ProductService.getRandomProduct());
    }


    public void addNewProduct(ImgProduct... imgProducts) {

        for (ImgProduct product : imgProducts) {
            productsList.add(product);
        }

    }

    public List<ImgProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ImgProduct> productsList) {
        this.productsList = productsList;
    }
}
