package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.appcrews.javaee.maicai.model.base.WareInfo;

import java.util.List;

/**
 * Created by micheal on 2017/7/17.
 */
public interface userService   extends baseService<UserInfo> {
        int ShopNum(int uid);

//    int getcountTotalPage(int pageSize);

}
