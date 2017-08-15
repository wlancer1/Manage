package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.AdminInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Admin {

      AdminInfo getAdminInfo(String account);//以用户名查询密码
     int getLength();  //获取admin条数

}
