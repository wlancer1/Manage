package com.appcrews.javaee.maicai.service.impl;

import com.appcrews.javaee.maicai.dal.*;
import com.appcrews.javaee.maicai.model.base.AdminInfo;
import com.appcrews.javaee.maicai.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micheal on 2017/2/16.
 */
@Transactional
@Service
public class adminServiceImp extends  baseServiceImp<AdminInfo> implements adminService {

    @Autowired
   private Admin admin;
    @Autowired
   private Data data;
    @Autowired
   private User user;
    @Autowired
   private Order order;
    private  List list;
    private AdminInfo adminInfo;


    @Override
    public int validate(String account, String password) {
            adminInfo=admin.getAdminInfo(account);
            if(adminInfo!=null){
               if(adminInfo.getPassword().equals(password))
                   return 1;
               else
                   return -1;

            }else
                return -1;
    }

    @Override
    public List<Integer> sizeList() {
        list=new ArrayList();
        list.add(user.getLength());
         list.add(data.getLength());
         list.add(order.getLength());
        return list;
    }
}
