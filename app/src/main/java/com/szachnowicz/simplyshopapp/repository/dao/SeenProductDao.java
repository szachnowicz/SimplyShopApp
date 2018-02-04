package com.szachnowicz.simplyshopapp.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.SeenProduct;

import java.util.List;

/**
 * Created by Sebastian on 2018-02-03.
 */
@Dao
public interface SeenProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRecord(SeenProduct seenProduct);

    @Query("select * from SeenProduct")
    public List<SeenProduct> getAllProducts();

}
