package com.szachnowicz.simplyshopapp.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.SeenProduct;

import java.util.List;

/**
 * Created by Sebastian on 2018-02-04.
 */
@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRecord(Order order);

    @Update
    void update(Order... orders);

    @Query("SELECT * FROM `Order`")
    List<Order> getAllOrders();


    @Query("SELECT * FROM `Order` WHERE userId=:userId")
    List<Order> getUnComplitedOrderForUser(final long userId);




}
