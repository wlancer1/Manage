package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.AdminInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Admin {

      AdminInfo getAdminInfo(String account);//以用户名查询密码
     List<Integer> getSizeList();  //获取admin条数

}
