package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.AdminInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/16.
 */
public interface adminService  extends baseService<AdminInfo> {
    int validate(String account, String password);//验证登录
    List<Integer> sizeList();//获取订单，使用者，产品数量。

}
