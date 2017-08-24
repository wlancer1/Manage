package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by micheal on 2017/8/23.
 */
@Repository
public class ShopImpl implements Shop {
    @Autowired
    BaseDaoI baseDaoI;
    @Override
    public  List<ShopInfo> query(int uid) {
        String hql="from ShopInfo where uid ="+uid;
        return baseDaoI.find(hql);
    }

    @Override
    public List<ShopInfo> getListShop() {
        String hql="from ShopInfo";
        return baseDaoI.find(hql);
    }

    @Override
    public int getLength() {
        String hql="SELECT COUNT(*) FROM ShopInfo";
        return baseDaoI.count(hql);
    }

}
