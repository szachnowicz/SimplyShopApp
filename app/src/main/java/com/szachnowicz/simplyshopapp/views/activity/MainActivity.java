package com.szachnowicz.simplyshopapp.views.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.szachnowicz.simplyshopapp.R;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.Order;
import com.szachnowicz.simplyshopapp.model.SeenProduct;
import com.szachnowicz.simplyshopapp.presenter.MainActivityPresenter;
import com.szachnowicz.simplyshopapp.repository.dao.OrderDao;
import com.szachnowicz.simplyshopapp.repository.repo.ImgProductRepo;
import com.szachnowicz.simplyshopapp.repository.repo.OrderItemRepo;
import com.szachnowicz.simplyshopapp.repository.repo.OrderRepo;
import com.szachnowicz.simplyshopapp.repository.repo.SeenProductRepo;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
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
        creatAndAddToDbOrder();
        testMethod();


    }

    private void creatAndAddToDbOrder() {
        Order order = new Order();
        order.setCompleted(false);
        order.setId(0);
        order.setUserId(0);
        new OrderRepo(getApplicationContext()).addRecord(order);
    }

    private void testMethod() {
        new OrderItemRepo(getApplicationContext()).getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(order -> {
                    Toasty.success(getApplicationContext(), order.getId()+"", Toast.LENGTH_SHORT).show();
                });

//        new SeenProductRepo(getApplicationContext()).getAllRecords()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).
//                subscribe(abstractProduct -> {
//                    Toasty.success(getApplicationContext(), abstractProduct.getImgProduct().getName(), Toast.LENGTH_SHORT).show();
//                });


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
