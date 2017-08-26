package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
 public interface Order {
//     OrderInfo getOrderInfo(int id);
//    void delete(int id, String onum) ;//删除
//     void deleteorder(String onum);//删除订单
//     void update(int number, int SCid, int onum, int index);//编辑
//     List<OrderInfo> getListorder();
//     List<OrderInfo> getList(int index);

    List<DetailInfo> getListdetailorder(int ounm);
    //    List<OrderInfo> getListsort(String name);
    List<OrderInfo> getListOrder();
    List<OrderInfo> getListOrder(int pageNo,int pageSize);
        int count(int index);
        int getLength();

}
