package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.UserInfo;

import java.util.List;

/**
 * Created by micheal on 2017/7/17.
 */
public interface userService {
    List<UserInfo> query();
    UserInfo query(int uid);//按uid查询
    int update(UserInfo u);

}
