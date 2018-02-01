package com.szachnowicz.simplyshopapp.services;

import com.szachnowicz.simplyshopapp.model.AbstractProduct;
import com.szachnowicz.simplyshopapp.model.ImgProduct;
import com.szachnowicz.simplyshopapp.model.NoImgProduct;

/**
 * Created by Sebastian on 2018-02-01.
 */

public class ProductService  {



    public  static AbstractProduct getRandomProduct(){

            if(Math.random()>0.5)
                return new ImgProduct();
            else
                return new NoImgProduct();




    }

}
