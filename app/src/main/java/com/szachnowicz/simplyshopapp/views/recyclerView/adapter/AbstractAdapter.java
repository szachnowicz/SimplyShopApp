package com.szachnowicz.simplyshopapp.views.recyclerView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.szachnowicz.simplyshopapp.views.recyclerView.holders.AbstractHolder;

/**
 * Created by Sebastian on 2017-11-17.
 */

public abstract class AbstractAdapter extends RecyclerView.Adapter<AbstractHolder> {

    protected final Context context;
    protected LayoutInflater inflater;

    protected AbstractAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

}
