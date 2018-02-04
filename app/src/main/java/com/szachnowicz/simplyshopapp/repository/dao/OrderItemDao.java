package com.szachnowicz.simplyshopapp.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.OrderItem;

import java.util.List;

import retrofit2.http.DELETE;

/**
 * Created by Sebastian on 2018-02-04.
 */
@Dao
public interface OrderItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRecord(OrderItem item);

    @Update
    void update(OrderItem... items);

    @Query("SELECT * FROM `OrderItem` WHERE orderId=:orderId")
    List<OrderItem> getAllOrder(final long orderId);

    @DELETE
    void delete(OrderItem orderItem);
}
