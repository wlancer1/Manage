package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Shop;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.PageInfo;
import com.appcrews.javaee.maicai.model.ShopInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Shop shop;
//   @Autowired
//   private  Order order;
    @Autowired
    private User user;
    @Override
    public List<UserInfo> getQueryForPage(int pageno, int pagesize) {
        return user.getListUser(pageno,pagesize);
    }


    @Override
    public int getcountTotalPage(int pagesize) {
        int length=user.getLength();
        return PageInfo.countTotalPage(pagesize,length);
    }

    @Override
    public UserInfo getUserInfo(int uid) {
        return (UserInfo) baseDaoI.get(UserInfo.class,uid);
    }

    @Override
    public int ShopNum(int uid) {
        return shop.query(uid).size();
    }

    @Override
    public int update(UserInfo u) {
        baseDaoI.update(u);
        return 1;
    }
}
