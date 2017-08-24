package com.appcrews.javaee.maicai.service;
import com.appcrews.javaee.maicai.dal.BaseDaoI;
import  com.appcrews.javaee.maicai.dal.Order;
import  com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.dal.User;
import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.WareInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
@Transactional
@Service
public class orderServiceImp implements orderService {
    @Autowired
    private Order order;
    @Autowired
    private Data data;
    @Autowired
    private User user;
    @Autowired
    private BaseDaoI baseDaoI;
     private DetailInfo detailInfo;
    private WareInfo wareInfo;
    private List<DetailInfo> detList;
//    @Override
//    public List<OrderInfo> getList(int index) {
//        return this.order.getList(index);
//    }


    @Override
    public List<OrderInfo> getListorder() {
        return this.order.getListOrder();
    }

    @Override
    public List<DetailInfo> getListdetailorder(int ounm) {

        detList=this.order.getListdetailorder(ounm);
        for(int i=0;i<detList.size();i++){
            detailInfo =detList.get(i);
           wareInfo =(WareInfo) baseDaoI.get(WareInfo.class,detList.get(i).getWareid());
            detailInfo.setImg(wareInfo.getImg());
            detailInfo.setID(wareInfo.getId());
            detailInfo.setName(wareInfo.getName());
            detailInfo.setPrice(wareInfo.getPrice());
        }
        return detList;
    }
    @Override
    public List<OrderInfo> getqueryForPage(int pageNo,int pageSize) {
        return this.order.getListOrder(pageNo,pageSize);
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
@Override
public int getcountTotalPage(int pagesize) {
    int length=order.getLength();
    return countTotalPage(pagesize,length);
}
    @Override
    public boolean queryUid(int id) {
        if(this.order.count(id)==0)
            return false;
        else
            return  true;
    }
    public static int countTotalPage(final int pageSize, final int allRow) {
        int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        return totalPage;
    }
//    @Override
//    public void deleteorder(String onum) {
//        this.order.deleteorder(onum);
//    }
}
