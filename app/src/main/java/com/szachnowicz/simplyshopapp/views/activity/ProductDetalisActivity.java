package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.repository.repo.ImgProductRepo;
import com.szachnowicz.simplyshopapp.repository.repo.SeenProductRepo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetalisActivity extends AppCompatActivity {
    final public static String JSON = "JSON";
    @BindView(R.id.imageViewPDetalis)
    ImageView producImageView;
    @BindView(R.id.productNamePDetalis)
    EditText productName;
    @BindView(R.id.productDiscpPDetalis)
    EditText productDiscp;
    @BindView(R.id.productPricePDetalis)
    EditText producPrice;
    @BindView(R.id.sealssalesmanInfoPD)
    EditText sealsManInfo;
    @BindView(R.id.progressBarPDetalis)
    ProgressBar progressBar;

    private ImgProduct product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detalis);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String json = extras.getString(JSON);
            product = new ImgProduct().fromJson(json);
            putProductDataOnView(product);
        }

        // adding produc to local db
        new ImgProductRepo(getApplicationContext()).addRecord(product);
        // adding to SeenProduct with referece to tabel above
        final SeenProduct seenProduct = new SeenProduct(product);
        new SeenProductRepo(getApplicationContext()).addRecord(seenProduct);





    }

    private void putProductDataOnView(ImgProduct product) {
        loadPic(product.getUrl());
        productName.setText(product.getName());
        producPrice.setText(product.getPrice().toString());
        productDiscp.setText(product.getDiscription());


    }

    private void loadPic(String url) {

        Picasso.with(this).load(url).into(producImageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

}
