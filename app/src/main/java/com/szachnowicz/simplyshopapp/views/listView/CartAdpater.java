package com.szachnowicz.simplyshopapp.views.listView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sebastian on 2018-02-04.
 */

public class CartAdpater extends ArrayAdapter<OrderItem> {
    private final Context context;
    private List<OrderItem> orderItemList;


    @BindView(R.id.productPicView)
    ImageView imageView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.itemName)
    EditText productName;
    @BindView(R.id.itemsNo)
    EditText productQuantity;
    @BindView(R.id.addButton)
    ImageButton addButton;
    @BindView(R.id.removeButton)
    ImageButton removeButton;


    public CartAdpater(@NonNull Context context, List<OrderItem> orderItemList) {
        super(context, -1, orderItemList);
        this.orderItemList = orderItemList;
        this.context = context;
    }


    public void addToList(OrderItem orderItem) {
        if (orderItemList != null) {
            orderItemList = new ArrayList<>();
        }
        orderItemList.add(orderItem);
        notifyDataSetChanged();
    }


    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.cart_list_layout, parent, false);
        ButterKnife.bind(this, rowView);

        final OrderItem orderItem = orderItemList.get(position);
        final ImgProduct imgProduct = orderItem.getImgProduct();
        productName.setText(imgProduct.getName());
        setQuanityty(orderItem);

        addButton.setOnClickListener(view -> {
            int quantity = orderItem.getQuantity() + 1;
            orderItem.setQuantity(quantity);
            setQuanityty(orderItem);

        });

        removeButton.setOnClickListener(view -> {
            int quantity = orderItem.getQuantity() - 1;
            if (quantity >= 0) {
                orderItem.setQuantity(quantity);
                setQuanityty(orderItem);
            }
        });


        Picasso.with(context).load(imgProduct.getUrl()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

        return rowView;
    }

    private void setQuanityty(OrderItem orderItem) {
        productQuantity.setText(orderItem.getQuantity() + "");
    }
}
