package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Order;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micheal on 2017/7/17.
 */
@Transactional
@Service
public class userServiceImpl implements userService {
    @Autowired
    private BaseDaoI baseDaoI;
   @Autowired
   private  Order order;
    @Autowired
    private User user;
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
            salerUser(sale,userInfo);
            userInfoList.add(userInfo);
        }
        for (BuyerInfo buyer : buyerInfoList) {
            userInfo = new UserInfo();
            buyerUser(buyer,userInfo);
            userInfoList.add(userInfo);
        }

        return userInfoList;
    }
    @Override
    public UserInfo query(int uid) {
        userInfo = new UserInfo();
        if (uid < 2000000) {
            sale = (SaleInfo)baseDaoI.get(SaleInfo.class,uid);
//            userInfo.setId(sale.getUserid());
//            userInfo.setPower(sale.getPower());
//            userInfo.setName(sale.getUsername());
//            userInfo.setEmail(sale.getEmail());
//            userInfo.setStatus(sale.getStatus());
//            userInfo.setPhone(sale.getTele());
            salerUser(sale,userInfo);
        } else {
            buyer = (BuyerInfo) baseDaoI.get(BuyerInfo.class,uid);
//            userInfo.setId(buyer.getId());
//            userInfo.setPower(buyer.getPower());
//            userInfo.setName(buyer.getBemail());
//            userInfo.setEmail(buyer.getBname());
//            userInfo.setPhone(buyer.getBtele());
//            userInfo.setStatus(buyer.getStatus());
            buyerUser(buyer,userInfo);
        }

        return userInfo;
    }
    @Override
    public int update(UserInfo u) {
//        if (u.getId() / 1000000 != u.getPower()) {
//
//            if(order.count(u.getId())!=0)
//                return 0;
//            try{
//                user.change(u.getId());
//            }catch (Exception e){
//                System.out.println(e);
//                return  -1;
//            }
//
//
//        }
    if(u.getPower()==1){
        sale=new SaleInfo(u.getId(),u.getName(),u.getEmail(),u.getPower(),u.getPhone(),u.getStatus());
        if (u.getId() / 1000000 != u.getPower()) {
            user.delete(u.getId());
            baseDaoI.save(sale);
            return  1;
        }
        try{
            baseDaoI.update(sale);
        }catch (Exception e){

            return  -1;
        }
    } else{
        buyer=new BuyerInfo(u.getId(),u.getName(),u.getEmail(),u.getPower(),u.getPhone(),u.getStatus());
        if (u.getId() / 1000000 != u.getPower()) {
            user.delete(u.getId());
            baseDaoI.save(buyer);
            return  1;
        }
        try{
            baseDaoI.update(buyer);
        }catch (Exception e){
            return  -1;
        }
    }

        return 1;
}

    public void salerUser(SaleInfo sale,UserInfo userInfo){
            userInfo.setId(sale.getUserid());
            userInfo.setPower(sale.getPower());
            userInfo.setName(sale.getUsername());
            userInfo.setEmail(sale.getEmail());
            userInfo.setStatus(sale.getStatus());
            userInfo.setPhone(sale.getTele());

        }
    public void buyerUser(BuyerInfo buyer,UserInfo userInfo){
        userInfo.setId(buyer.getId());
        userInfo.setPower(buyer.getPower());
        userInfo.setName(buyer.getBname());
        userInfo.setEmail(buyer.getBemail());
        userInfo.setPhone(buyer.getBtele());
        userInfo.setStatus(buyer.getStatus());

    }

}
