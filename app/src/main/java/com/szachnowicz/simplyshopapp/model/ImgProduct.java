package com.szachnowicz.simplyshopapp.model;

import com.szachnowicz.simplyshopapp.services.Nouns;

import java.math.BigDecimal;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ImgProduct extends AbstractProduct {

    private String photoPath;

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ImgProduct() {
        super(0);

    }
}
