package com.appcrews.javaee.maicai.service.impl;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Shop;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.appcrews.javaee.maicai.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by micheal on 2017/7/17.
 */
@Transactional
@Service
public class userServiceImpl extends baseServiceImp<UserInfo> implements userService {
    @Autowired
    private BaseDaoI baseDaoI;
    @Autowired
    private Shop shop;
//   @Autowired
//   private  Order order;
    @Autowired
    private User user;

    private UserInfo userInfo;


    @Override
    public int validate(String account, String password) {
       userInfo=user.getUserInfo(account);
        if(userInfo!=null){
            if(userInfo.getPassword().equals(password))
                return userInfo.getUid();
            else
                return -1;

        }else
            return -1;
    }


    @Override
    public int ShopNum(int uid) {
        return shop.query(uid).size();
    }

    @Override
    public int getcount(int x) {
        return user.count(x);
    }
}
