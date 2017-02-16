package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.Admin;

import java.util.List;

/**
 * Created by micheal on 2017/2/16.
 */

public class adminServiceImp implements adminService {

   private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public int panduan(String account, String password) {
             return  admin.panduan(account,password);
    }

    @Override
    public List<Integer> sizeList() {
       return admin.sizeList();
    }
}
