package com.szachnowicz.simplyshopapp.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Sebastian on 2018-02-04.
 */
@Entity(foreignKeys = @ForeignKey(entity = Order.class,
        parentColumns = "id",
        childColumns = "orderId",
        onDelete = CASCADE))
public class OrderItem {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public long orderId;

    @Embedded
    public ImgProduct imgProduct;

    public int quantity;

    public long getId() {
        return id;
    }

    public long getOrderId() {
        return orderId;
    }

    public ImgProduct getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(ImgProduct imgProduct) {
        this.imgProduct = imgProduct;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
