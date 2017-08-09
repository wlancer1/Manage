package com.appcrews.javaee.maicai.service;
import  com.appcrews.javaee.maicai.dal.Order;
import  com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.WareInfo;
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
     private DetailInfo detailInfo;
    private WareInfo wareInfo;
    private List<DetailInfo> detList;
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

        detList=this.order.getListdetailorder(ounm);
        for(int i=0;i<detList.size();i++){
            detailInfo =detList.get(i);
           wareInfo =data.getShucaiInfo(detList.get(i).getSCid());
            detailInfo.setImg(wareInfo.getImg());
            detailInfo.setID(wareInfo.getId());
            detailInfo.setName(wareInfo.getName());
            detailInfo.setPrice(wareInfo.getPrice());
        }
        return detList;
    }

    @Override
    public void delete(int id, String onum) {
        this.order.delete(id,onum);
    }
    @Override
    public OrderInfo getOrderInfo(int id){
        return this.order.getOrderInfo(id);
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
    public boolean query(int id) {
        if(this.order.count(id)==0)
            return false;
        else
            return  true;
    }

    @Override
    public void deleteorder(String onum) {
        this.order.deleteorder(onum);
    }
}
