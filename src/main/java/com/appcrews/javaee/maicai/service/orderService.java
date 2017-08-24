package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface orderService {
    boolean queryUid(int id);//
    List<DetailInfo> getListdetailorder(int ounm);
    List<OrderInfo> getListorder();
    List<OrderInfo> getqueryForPage(int pageNo,int pageSize);
    int getcountTotalPage(int pagesize);

//    List<OrderInfo> getList(int index);
//
//    void delete(int id, String onum) ;
//     OrderInfo getOrderInfo(int id);
//    void deleteorder(String onum);
//    void update(int number, int SCid, int onum, int index);//

}
