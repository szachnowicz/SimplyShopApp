package com.szachnowicz.simplyshopapp.views.recyclerView.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.OrderItem;
import com.szachnowicz.simplyshopapp.repository.repo.OrderItemRepo;
import com.szachnowicz.simplyshopapp.views.activity.ProductDetalisActivity;
import com.szachnowicz.simplyshopapp.views.recyclerView.holders.AbstractHolder;
import com.szachnowicz.simplyshopapp.views.recyclerView.holders.ShopProductHolder;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ShopProductAdapter extends AbstractAdapter {

    private List<ImgProduct> productsList;
    private Order order;

    public ShopProductAdapter(Context context, @NonNull List<ImgProduct> productsList) {
        super(context);
        this.productsList = productsList;
    }

    @Override
    public AbstractHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item_adapter, parent, false);
        return new ShopProductHolder(view);
    }

    @Override
    public void onBindViewHolder(AbstractHolder holder, int position) {
        ShopProductHolder itemHolder = (ShopProductHolder) holder;


        ImgProduct product = productsList.get(position);
        itemHolder.itemName.setText(product.getName());
        itemHolder.itemDiscp.setText(product.getDiscription());
        itemHolder.itemPrice.setText(product.getPrice());
        Picasso.with(context).load(product.getUrl()).into(itemHolder.itemImage, new Callback() {
            @Override
            public void onSuccess() {
                itemHolder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });


        itemHolder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(context, ProductDetalisActivity.class);
            intent.putExtra(ProductDetalisActivity.JSON, product.toJson(product));
            context.startActivity(intent);

        });

        itemHolder.addToCartButton.setOnClickListener(view -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(1);
            orderItem.setImgProduct(product);
            orderItem.setOrderId(order.getId());

            new OrderItemRepo(context).addRecord(orderItem);

        });

        itemHolder.addToFavoriteButton.setOnClickListener(view -> {
            Toasty.success(context, context.getString(R.string.addedToFavorite), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public void addNewProduct(ImgProduct... products) {

        for (ImgProduct imgProduct : products) {
            productsList.add(imgProduct);
        }
        notifyDataSetChanged();
    }

    public List<ImgProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ImgProduct> productsList) {
        this.productsList = productsList;
    }

    public void setCurrnetOrder(Order order) {
        this.order = order;
    }
}


