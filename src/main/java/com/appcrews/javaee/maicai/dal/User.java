package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface User {
     List<SaleInfo> getlists();
    int size();
     SaleInfo getsaleinfo(int index);
     BuyerInfo getbuyinfo(int index);
    List<BuyerInfo> getlistb();
}
