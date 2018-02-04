package com.szachnowicz.simplyshopapp.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.szachnowicz.simplyshopapp.model.ImgProduct;

import java.util.List;

/**
 * Created by Sebastian on 2018-02-03.
 */
@Dao
public interface ProductDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRecord(ImgProduct imgProduct);

    @Query("select * from ImgProduct")
    public List<ImgProduct> getAllProducts();


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(ImgProduct imgProduct);

    @Query("delete from ImgProduct")
    void removeAllUsers();
}
