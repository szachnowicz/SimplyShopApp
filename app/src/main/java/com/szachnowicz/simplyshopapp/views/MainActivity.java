package com.szachnowicz.simplyshopapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nightonke.boommenu.BoomMenuButton;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private MainActivityPresenter presenter;

    @BindView(R.id.mainMenu)
    BoomMenuButton boomMenuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(getApplicationContext());
        presenter.initMenu(boomMenuButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        boomMenuButton.post(new Runnable() {
            @Override
            public void run() {
                boomMenuButton.boom();
            }
        });

    }
}
