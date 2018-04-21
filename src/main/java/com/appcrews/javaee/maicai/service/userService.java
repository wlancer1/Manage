package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.UserInfo;

/**
 * Created by micheal on 2017/7/17.
 */
public interface userService extends baseService<UserInfo> {
        int ShopNum(int uid);
        public int validate(String account, String password);
//    int getcountTotalPage(int pageSize);
        public  int getcount(int x);

}
