package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.AdminInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Admin {
//     int panduan(String account, String password);
     List<Integer> sizeList();
     List<AdminInfo> getList();

}
