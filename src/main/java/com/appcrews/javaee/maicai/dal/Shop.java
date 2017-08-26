package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.ShopInfo;

import java.util.List;

/**
 * Created by micheal on 2017/8/23.
 */
public interface Shop {
    List<ShopInfo> query(int uid);
    List<ShopInfo> getListShop();
    int getLength();
}
