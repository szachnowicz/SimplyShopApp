package com.szachnowicz.simplyshopapp.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.views.BrowseActivity;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class MainActivityPresenter {
    private Context context;

    public MainActivityPresenter(Context context) {
        this.context = context;
    }

    public void initMenu(BoomMenuButton boomMenuButton) {

        boomMenuButton.addBuilder(getSearchInShopBulider());
        boomMenuButton.addBuilder(getYourOrderBulider());
        boomMenuButton.addBuilder(getOrderHistoryBulider());
        boomMenuButton.addBuilder(getUserAccountDetails());


    }

    private HamButton.Builder getOrderHistoryBulider() {
        HamButton.Builder builder = new HamButton.Builder();
        builder.normalColor(Color.parseColor("#CFB53B"))
                .normalTextRes(R.string.orderHistory)
                .subNormalTextRes(R.string.orderHistorySub)
                .normalImageRes(R.drawable.ic_history)
                .listener(index -> {
                })
                .build(context);
        return builder;
    }

    private HamButton.Builder getUserAccountDetails() {
        HamButton.Builder builder = new HamButton.Builder();
        builder.normalColor(Color.parseColor("#CFB53B"))
                .normalTextRes(R.string.yourAccount)
                .subNormalTextRes(R.string.yourAccountSub)
                .normalImageRes(R.drawable.ic_account)
                .listener(index -> {
                })
                .build(context);
        return builder;
    }

    private HamButton.Builder getYourOrderBulider() {
        HamButton.Builder builder = new HamButton.Builder();
        builder.normalColor(Color.parseColor("#CFB53B"))
                .normalText(context.getString(R.string.yourOrder))
                .subNormalTextRes(R.string.yourOrderSub)
                .normalImageRes(R.drawable.ic_recent_order)
                .listener(index -> {
                })
                .build(context);
        return builder;
    }

    private HamButton.Builder getSearchInShopBulider() {
        HamButton.Builder builder = new HamButton.Builder();
        builder.normalColor(Color.parseColor("#CFB53B"))
                .normalText(context.getString(R.string.searchInShop))
                .subNormalTextRes(R.string.searchInShopSub)
                .normalImageRes(R.drawable.ic_search)
                .listener(index -> {
                    Intent intent = new Intent(context, BrowseActivity.class);
                    context.startActivity(intent);

                })
                .build(context);
        return builder;
    }
}
