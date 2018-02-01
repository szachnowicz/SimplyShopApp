package com.szachnowicz.simplyshopapp.views.recyclerView.holders;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.szachnowicz.simplyshopapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ShopItemHolder extends AbstractHolder {
    @BindView(R.id.productImg)
    public ImageView itemImage;
    @BindView(R.id.productName)
    public EditText itemName;
    @BindView(R.id.productDiscp)
    public EditText itemDiscp;
    @BindView(R.id.productPrice)
    public EditText itemPrice;


    public ShopItemHolder(View view) {
        super(view);
        ButterKnife.bind(view);
    }
}
