package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.UserInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface User {
        int getLength();
    List<UserInfo> getListUser();
    List<UserInfo> getListUser(int pageNo, int pageSize);


}
