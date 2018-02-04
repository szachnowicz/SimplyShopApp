package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.presenter.MainActivityPresenter;
import com.szachnowicz.simplyshopapp.repository.repo.ImgProductRepo;
import com.szachnowicz.simplyshopapp.repository.repo.SeenProductRepo;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        testMethod();


    }

    private void testMethod() {
//        final ImgProductRepo imgProductRepo = new ImgProductRepo(getApplicationContext());
//
////        imgProductRepo.getAllRecords().subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread()).
////                subscribe(abstractProduct -> {
////                    Toasty.success(getApplicationContext(), abstractProduct.getName(), Toast.LENGTH_SHORT).show();
////                });

        new SeenProductRepo(getApplicationContext()).getAllRecords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(abstractProduct -> {
                    Toasty.success(getApplicationContext(), abstractProduct.getImgProduct().getName(), Toast.LENGTH_SHORT).show();
                });






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
