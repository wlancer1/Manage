package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.Order;
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
    @Autowired
    private Order order;
    private UserInfo userInfo;
    private SaleInfo sale;
    private BuyerInfo buyer;
    private List<UserInfo> userInfoList;
    private List<SaleInfo> saleInfoList;
    private List<BuyerInfo> buyerInfoList;

    @Override
    public List<UserInfo> query() {
        saleInfoList = user.getlists();
        buyerInfoList = user.getlistb();
        userInfoList = new ArrayList<>();

        for (SaleInfo sale : saleInfoList) {
            userInfo = new UserInfo();
            userInfo.setId(sale.getUserid());
            userInfo.setPower(sale.getPower());
            userInfo.setName(sale.getUsername());
            userInfo.setEmail(sale.getEmail());
            userInfo.setStatus(sale.getStatus());
            userInfo.setPhone(sale.getTele());
            userInfoList.add(userInfo);
        }
        for (BuyerInfo buyer : buyerInfoList) {
            userInfo = new UserInfo();
            userInfo.setId(buyer.getId());
            userInfo.setPower(buyer.getPower());
            userInfo.setName(buyer.getBemail());
            userInfo.setEmail(buyer.getBname());
            userInfo.setPhone(buyer.getBtele());
            userInfo.setStatus(buyer.getStatus());
            userInfoList.add(userInfo);
        }

        return userInfoList;
    }

    @Override
    public UserInfo query(int uid) {
        userInfo = new UserInfo();
        if (uid < 2000000) {
            sale = user.getsaleinfo(uid);
            userInfo.setId(sale.getUserid());
            userInfo.setPower(sale.getPower());
            userInfo.setName(sale.getUsername());
            userInfo.setEmail(sale.getEmail());
            userInfo.setStatus(sale.getStatus());
            userInfo.setPhone(sale.getTele());
        } else {
            buyer = user.getbuyinfo(uid);
            userInfo.setId(buyer.getId());
            userInfo.setPower(buyer.getPower());
            userInfo.setName(buyer.getBemail());
            userInfo.setEmail(buyer.getBname());
            userInfo.setPhone(buyer.getBtele());
            userInfo.setStatus(buyer.getStatus());
        }

        return userInfo;
    }

    @Override
    public int update(UserInfo u) {
        try{
            user.update(u);
        }catch (Exception e){
            return  -1;
        }

        if (u.getId() / 1000000 != u.getPower()) {
            if(order.count(u.getId())!=0)
                    return 0;
            try{
                user.insert(u.getId());
                user.delete(u.getId());
            }catch (Exception e){
                return  -1;
            }


        }
        return 1;
}
}
