package com.appcrews.javaee.maicai.service;

import java.util.List;

/**
 * Created by micheal on 2017/2/16.
 */
public interface adminService {
    int panduan(String account, String password);
    List<Integer> sizeList();
}
