package com.appcrews.javaee.maicai;



import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Order;
import com.appcrews.javaee.maicai.model.base.AdminInfo;
import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.service.baseService;
import com.appcrews.javaee.maicai.service.impl.baseServiceImp;
import com.appcrews.javaee.maicai.tool.HqlFilter;
import com.appcrews.javaee.maicai.tool.MD5;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by micheal on 2017/8/6.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testmysql{
    @Autowired
    Admin admin;
    AdminInfo adminInfo;
    @Autowired
    Order order;
    @Autowired
    BaseDaoI baseDaoI;
    List<OrderInfo> OrderList;
    private Set<DetailInfo> detailInfo;
    @Resource(name="sessionFactory")
    private SessionFactory em;
    private Map map;
    private static final Logger log = LogManager.getLogger();

    private baseService service;

    @Transactional
    @Test
    public void test(){
        HibernateEntityManager hEntityManager = (HibernateEntityManager)em;

        Session session =em.getCurrentSession();
        String account="admin";
        String sql="SELECT * from admin WHERE account='"+account+"'";
        String sql2="SELECT * FROM admin";
        String hql = "from AdminInfo  where account='admin'";
        adminInfo= (AdminInfo) session.createQuery(hql).uniqueResult();


    }
    @Transactional
    @Test
    @Rollback(false)
    public void addadmintest(){

        adminInfo=new AdminInfo();
        String password="zucc";
        String account="admin";
        adminInfo.setPassword(MD5.Encrypt(password,password.length()));
        adminInfo.setAccount(account);
        adminInfo.setPower(1);
        baseDaoI.save(adminInfo);
        adminInfo=new AdminInfo();
        password="admin";
        account="account";
        adminInfo.setPassword(MD5.Encrypt(password,password.length()));
        adminInfo.setAccount(account);
        adminInfo.setPower(1);
        baseDaoI.save(adminInfo);
        adminInfo=new AdminInfo();
        password="wyh";
        account="123456";
        adminInfo.setPassword(MD5.Encrypt(password,password.length()));
        adminInfo.setAccount(account);
        adminInfo.setPower(1);
        baseDaoI.save(adminInfo);
        adminInfo=new AdminInfo();
        password="admin";
        account="admin";
        adminInfo.setPassword(MD5.Encrypt(password,password.length()));
        adminInfo.setAccount(account);
        adminInfo.setPower(1);
        baseDaoI.save(adminInfo);
    }

    @Transactional
    @Test
    @Rollback(false)
    public void  testhql(){
        List<WareInfo> WareInfoList;
        HqlFilter hqlFilter=new HqlFilter();
//        hqlFilter.addFilter("QUERY_t#name_S_LK","白菜");
//       String hql="select distinct t from com.appcrews.javaee.maicai.model.base.WareInfo t ";
//        System.out.println(hql+hqlFilter.getWhereAndOrderHql()+'\n'+hqlFilter.getParams());
//        String hql="select distinct t from com.appcrews.javaee.maicai.model.base.WareInfo t where t.name like '%白%'";
        service=new baseServiceImp();
        hqlFilter.addSort("price");
        hqlFilter.addOrder("asc");

        baseDaoI.find("select distinct t from com.appcrews.javaee.maicai.model.base.WareInfo t order by t.price asc", hqlFilter.getParams(), 1, 5);


    }
    @Transactional
    @Test
    @Rollback(false)
    public void  ormtest(){
        OrderInfo orderInfo=new OrderInfo();
            DetailInfo detailInfo=new DetailInfo();
//        Set<DetailInfo> detailInfos=new HashSet<DetailInfo>();
        String onum=System.currentTimeMillis()%1000000+"100001";
        orderInfo.setOnum(onum);
        orderInfo.setUid(1);
//        String hql = "select distinct t from OrderInfo t";
//        OrderList=baseDaoI.find(hql,1,5);
//        detailInfo=OrderList.get(1).getDetailInfo();
//        log.info(detailInfo);
        detailInfo.setOnum(onum);
        detailInfo.setWareid(2);
        detailInfo.setWarenum(5);
//        detailInfo.setWareInfo((WareInfo) baseDaoI.get(WareInfo.class,2));
        orderInfo.getDetailInfo().add(detailInfo);
//        log.info(detailInfos);
//        orderInfo.setDetailInfo(detailInfos);
        baseDaoI.save(orderInfo);

    }

    @Transactional
    @Test
    @Rollback(false)
    public void hqltest(){
       List<OrderInfo> s;
        s=order.queryOnum("6836781");


    }
}
