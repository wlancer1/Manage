package com.appcrews.javaee.maicai.dal;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Admin {
     int panduan(String account, String password);
     List<Integer> sizeList();

}
