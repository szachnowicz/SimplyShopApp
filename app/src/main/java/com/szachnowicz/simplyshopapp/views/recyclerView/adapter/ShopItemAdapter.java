package com.szachnowicz.simplyshopapp.views.recyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.AbstractProduct;
import com.szachnowicz.simplyshopapp.views.recyclerView.holders.AbstractHolder;
import com.szachnowicz.simplyshopapp.views.recyclerView.holders.ShopItemHolder;

import java.util.List;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ShopItemAdapter extends AbstractAdapter {

    private List<AbstractProduct> productsList;

    public ShopItemAdapter(Context context, @NonNull List<AbstractProduct> productsList) {
        super(context);
        this.productsList = productsList;
    }

    @Override
    public AbstractHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item_adapter, parent, false);
        return new ShopItemHolder(view);
    }

    @Override
    public void onBindViewHolder(AbstractHolder holder, int position) {
        ShopItemHolder itemHolder = (ShopItemHolder) holder;
        AbstractProduct product = productsList.get(position);
        itemHolder.itemName.setText(product.getName());
        itemHolder.itemDiscp.setText(product.getDiscription());
        itemHolder.itemPrice.setText(product.getPrice().toString());
        if (product.getViewType() == 0) {
            Picasso.with(context).load("https://source.unsplash.com/800x600").into(itemHolder.itemImage);
        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public void addNewProduct(AbstractProduct... abstractProducts) {
        for (int i = 0; i < abstractProducts.length; i++) {
            productsList.add(abstractProducts[i]);
        }
        notifyDataSetChanged();
    }

}


