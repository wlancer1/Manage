package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.UserInfo;

import java.util.List;

/**
 * Created by micheal on 2017/7/17.
 */
public interface userService {
    List<UserInfo> getQueryForPage(int pageno,int pagesize);
    int update(UserInfo u);
    UserInfo getUserInfo(int uid);
int ShopNum(int uid);
    int getcountTotalPage(int pageSize);

}
