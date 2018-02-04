package com.szachnowicz.simplyshopapp.repository.repo;

import io.reactivex.Observable;

/**
 * Created by Sebastian on 2018-02-04.
 */

interface  ICrud<T> {

    Observable<T> getAll();

    void addRecord(T t);

    void removeRecord(T t);
}
