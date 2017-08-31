package com.appcrews.javaee.maicai;



import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.model.base.AdminInfo;
import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
    BaseDaoI baseDaoI;
    List<OrderInfo> OrderList;
    private Set<DetailInfo> detailInfo;
    @Resource(name="sessionFactory")
    private SessionFactory em;
    private Map map;
    private static final Logger log = LogManager.getLogger();

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
        HqlFilter hqlFilter=new HqlFilter();
        hqlFilter.addFilter("QUERY_t#name_S_EQ","白菜");
       String hql="select distinct t from com.appcrews.javaee.maicai.model.base.WareInfo t";
        baseDaoI.find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), 1, 5);
//        String hql="from UserInfo user   where 1=1  and user.uid  =  :param47285f31f17947f38056cb3697a8c153 ";
//        map=new HashMap();
//        map.put("param47285f31f17947f38056cb3697a8c153",5);
//        System.out.println(map);
//        System.out.println( "map========"+hqlFilter.getParams());
//       System.out.println( hql+hqlFilter.getWhereHql());
//        baseDaoI.get(hql+hqlFilter.getWhereHql(), hqlFilter.getParams());
    }
    @Transactional
    @Test
    @Rollback(false)
    public void  ormtest(){

        String hql = "select distinct t from OrderInfo t";
        OrderList=baseDaoI.find(hql,1,5);
        detailInfo=OrderList.get(1).getDetailInfo();
        log.info(detailInfo);
    }
}
