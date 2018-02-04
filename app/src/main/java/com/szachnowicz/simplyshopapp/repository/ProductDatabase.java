package com.szachnowicz.simplyshopapp.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.OrderItem;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.repository.dao.ProductDao;
import com.szachnowicz.simplyshopapp.repository.dao.SeenProductDao;


/**
 * Created by Sebastian on 2018-02-03.
 */
@Database(entities = {ImgProduct.class, SeenProduct.class, Order.class, OrderItem.class}, version = 6, exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

    private static volatile ProductDatabase INSTANCE;

    public abstract ProductDao productDao();

    public abstract SeenProductDao seenProductDao();

    public static ProductDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductDatabase.class, "Product.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}


