package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by micheal on 2017/2/22.
 */
public interface orderService extends baseService<OrderInfo> {
    public List<OrderInfo> getDetail(String id);
    public void  wareDelete(int id,int wareid);
    public List<OrderInfo> getByuserId(int uid);
//    public DetailInfo getDetailInfo(int id );
//    List<DetailInfo> getListdetailorder(int ounm);
//    List<OrderInfo> getListorder();
//    List<OrderInfo> getqueryForPage(int pageNo,int pageSize);
//    int getcountTotalPage(int pagesize);

//    List<OrderInfo> getList(int index);
//
//    void delete(int id, String onum) ;
//     OrderInfo getOrderInfo(int id);
//    void deleteorder(String onum);
//    void update(int number, int SCid, int onum, int index);//

}
