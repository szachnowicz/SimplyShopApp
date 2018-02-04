package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.OrderItem;
import com.szachnowicz.simplyshopapp.views.listView.CartAdpater;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity {
    @BindView(R.id.cartListView)
    ListView listView;
    private CartAdpater cartAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        List<OrderItem> imgProducts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final OrderItem orderItem = new OrderItem();
            orderItem.setImgProduct(new ImgProduct());
            imgProducts.add(orderItem);

        }
        cartAdpater = new CartAdpater(getApplicationContext(), imgProducts);
listView.setAdapter(cartAdpater);

    }


}
