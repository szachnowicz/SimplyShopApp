package com.szachnowicz.simplyshopapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sebastian on 2018-02-03.
 */
@Entity
public class SeenProduct {
    @PrimaryKey(autoGenerate = true)
    long id;
    @Embedded
    private ImgProduct imgProduct;

    private String date;

    public SeenProduct( ImgProduct imgProduct) {
        this.imgProduct = imgProduct;
        setDateFormat();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ImgProduct getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(ImgProduct imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dataString = sdf.format(new Date().getTime());
        setDate(dataString);
    }
}
