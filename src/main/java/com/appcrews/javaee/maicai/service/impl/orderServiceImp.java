package com.appcrews.javaee.maicai.service.impl;
import com.appcrews.javaee.maicai.dal.BaseDaoI;
import  com.appcrews.javaee.maicai.dal.Order;
import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.service.orderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
@Transactional
@Service
public class orderServiceImp extends baseServiceImp<OrderInfo> implements orderService {
    @Autowired
    private Order order;
    @Autowired
    private BaseDaoI baseDaoI;
    private OrderInfo orderInfo;
    private WareInfo wareInfo;
    private List<DetailInfo> detList;
//    @Override
//    public List<OrderInfo> getList(int index) {
//        return this.order.getList(index);
//    }

    @Override
    public List<OrderInfo> getByuserId(int uid) {
        return order.queryUid(uid);
    }


//    @Override
//    public void delete(int id, String onum) {
//        this.order.delete(id,onum);
//    }
//    @Override
//    public OrderInfo getOrderInfo(int id){
//        return this.order.getOrderInfo(id);
//    }
//
//
//
//    @Override
//    public void update(int number, int SCid, int onum, int index) {
//        this.order.update(number,SCid,onum,index);
//    }



   public OrderInfo getDetail(int id){

      orderInfo=(OrderInfo) baseDaoI.get(OrderInfo.class,id);
       Hibernate.initialize(orderInfo.getDetailInfo());
       return orderInfo;
   }

    @Override
    public void wareDelete(int id, int wareid) {
        order.deleteDetail(id,wareid);
    }

    @Override
    public void CreateOrder(OrderInfo orderInfo) {

    }
}
