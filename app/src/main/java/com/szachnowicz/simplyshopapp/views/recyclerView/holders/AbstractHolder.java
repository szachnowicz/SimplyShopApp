package com.szachnowicz.simplyshopapp.views.recyclerView.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Sebastian on 2017-11-17.
 */

public abstract class AbstractHolder extends RecyclerView.ViewHolder  {

    public AbstractHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }



}
