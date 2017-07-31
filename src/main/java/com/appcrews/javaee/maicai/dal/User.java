package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.UserInfo;

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
    void update(UserInfo userInfo);
    void insert(BuyerInfo buyerInfo);//buyer表插入
    void insert(SaleInfo saleInfo);//saler表插入
    void delete(int index);
    void insert(int index);

}
