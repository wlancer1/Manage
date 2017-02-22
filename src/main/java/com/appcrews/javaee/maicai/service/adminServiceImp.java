package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by micheal on 2017/2/16.
 */

@Service
public class adminServiceImp implements adminService {
    @Autowired
   private Admin admin;


    @Override
    public int panduan(String account, String password) {
            List<AdminInfo> list=this.admin.getList();
        for (int i = 0; i < list.size(); i++) {
            String am = list.get(i).getAccount();
            String pm = list.get(i).getPassword();
            am = MD5.Encrypt(am, am.length());
            pm = MD5.Encrypt(pm, pm.length());
            if (am.equals(account) && pm.equals(password)) {
                return list.get(i).getPower();
            }
        }
        return -1;
    }

    @Override
    public List<Integer> sizeList() {
       return admin.sizeList();
    }
}
