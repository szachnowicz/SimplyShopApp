package com.szachnowicz.simplyshopapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.szachnowicz.simplyshopapp.services.Nouns;

import java.math.BigDecimal;

/**
 * Created by Sebastian on 2018-02-01.
 */
@Entity
public abstract class AbstractProduct {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String discription;
    private BigDecimal price;
    private int viewType;

    public AbstractProduct(int viewType) {
        this.viewType = viewType;
        setName(Nouns.getRandomNoun());
        setDiscription(Nouns.getRandomNouns(10));
        setPrice(new BigDecimal("10.00"));
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
