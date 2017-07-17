package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micheal on 2017/7/17.
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private User user;
    private UserInfo userInfo;
    private List<UserInfo> userInfoList;
    private List<SaleInfo> saleInfoList;
    private List<BuyerInfo> buyerInfoList;
    @Override
    public List<UserInfo> query() {
        saleInfoList=user.getlists();
        buyerInfoList=user.getlistb();
        userInfoList=new ArrayList<>();

        for(SaleInfo sale:saleInfoList){
            userInfo=new UserInfo();
            userInfo.setId(10000+sale.getUserid());
            userInfo.setPower(sale.getPower());
            userInfo.setName(sale.getUsername());
            userInfo.setEmail(sale.getEmail());
            userInfoList.add(userInfo);
        }
        for(BuyerInfo buyer:buyerInfoList){
            userInfo=new UserInfo();
            userInfo.setId(20000+buyer.getId());
            userInfo.setPower(buyer.getPower());
            userInfo.setName(buyer.getBemail());
            userInfo.setEmail(buyer.getBname());
            userInfoList.add(userInfo);
        }

        return userInfoList;
    }
}
