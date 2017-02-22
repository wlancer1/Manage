package com.appcrews.javaee.maicai.service;
import  com.appcrews.javaee.maicai.dal.Order;
import  com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.ShucaiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
@Service
public class orderServiceImp implements orderService {
    @Autowired
    private Order order;
    @Autowired
    private Data data;
    @Autowired
    private User user;
    @Override
    public List<OrderInfo> getList(int index) {
        return this.order.getList(index);
    }


    @Override
    public List<OrderInfo> getListorder() {
        return this.order.getListorder();
    }

    @Override
    public List<DetailInfo> getListdetailorder(int ounm) {
        return this.order.getListdetailorder(ounm);
    }

    @Override
    public void delete(int id, String onum) {
        this.order.delete(id,onum);
    }
    @Override
    public OrderInfo getOrderInfo(int id){
        return this.getOrderInfo(id);
    }

    @Override
    public SaleInfo getsaleinfo(int index) {
        return this.getsaleinfo(index);
    }

    @Override
    public void update(int number, int SCid, int onum, int index) {
        this.order.update(number,SCid,onum,index);
    }

    @Override
    public void deleteorder(String onum) {
        this.order.deleteorder(onum);
    }
}
