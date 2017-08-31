package com.appcrews.javaee.maicai.service.impl;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Shop;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.appcrews.javaee.maicai.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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





    @Override
    public int ShopNum(int uid) {
        return shop.query(uid).size();
    }


}
