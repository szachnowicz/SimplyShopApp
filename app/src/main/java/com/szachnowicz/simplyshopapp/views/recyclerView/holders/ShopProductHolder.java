package com.szachnowicz.simplyshopapp.views.recyclerView.holders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.szachnowicz.simplyshopapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ShopProductHolder extends AbstractHolder {
    @BindView(R.id.productImg)
    public ImageView itemImage;
    @BindView(R.id.productName)
    public EditText itemName;
    @BindView(R.id.productDiscp)
    public EditText itemDiscp;
    @BindView(R.id.productPrice)
    public EditText itemPrice;

    @BindView(R.id.addToCartButton)
    public ImageButton addToCartButton;
    @BindView(R.id.addToFavoriteButton)
    public ImageButton addToFavoriteButton;
    @BindView(R.id.loadImgProgresssBar)
    public ProgressBar progressBar;


    public ShopProductHolder(View view) {
        super(view);
        ButterKnife.bind(view);
    }
}
