package com.szachnowicz.simplyshopapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.Gson;
import com.szachnowicz.simplyshopapp.services.IGsonCoverter;
import com.szachnowicz.simplyshopapp.services.Nouns;

import java.math.BigDecimal;

/**
 * Created by Sebastian on 2018-02-01.
 */
@Entity
public class ImgProduct implements IGsonCoverter  {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    private long id;

    private String name;
    private String discription;
    private String price;
    private int viewType;
    private String url;
    private String photoPath;

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ImgProduct() {
        setName(Nouns.getRandomNoun());
        setDiscription(Nouns.getRandomNouns(10));
        setPrice(Nouns.randomPrice());
        String baseUrl = "https://source.unsplash.com/640x320/?";
        setUrl(baseUrl + getName());
    }

    @Override
    public ImgProduct fromJson(String object) {
        Gson gson = new Gson();
        ImgProduct imgProduct = gson.fromJson(object, ImgProduct.class);
        return imgProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
