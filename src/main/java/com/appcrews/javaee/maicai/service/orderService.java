package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface orderService {
    List<OrderInfo> getListorder();
    List<OrderInfo> getList(int index);
    List<DetailInfo> getListdetailorder(int ounm);
    void delete(int id, String onum) ;
     OrderInfo getOrderInfo(int id);
    void deleteorder(String onum);
    SaleInfo getsaleinfo(int index);
    void update(int number, int SCid, int onum, int index);//
    boolean query(int id);
}
