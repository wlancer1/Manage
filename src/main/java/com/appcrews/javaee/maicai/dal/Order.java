package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
 public interface Order {

//     List<OrderInfo> getListorder();

    List<DetailInfo> getListdetailorder(int ounm);
        void deleteDetail(int onum,int wareid);
    List<OrderInfo> queryUid(int uid);
    List<OrderInfo> queryOnum(String onum);

}
