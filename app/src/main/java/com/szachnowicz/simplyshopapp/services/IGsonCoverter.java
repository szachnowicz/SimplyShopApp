package com.szachnowicz.simplyshopapp.services;

import com.google.gson.Gson;

/**
 * Created by Sebastian on 2018-02-03.
 */

public interface IGsonCoverter<T> {
    default String toJson(T object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    public T fromJson(String object);

}
