package com.appcrews.javaee.maicai;



import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
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


/**
 * Created by micheal on 2017/8/6.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserAdd {
    @Autowired
    Admin admin;
    AdminInfo adminInfo;
    @Autowired
    BaseDaoI baseDaoI;
    @Resource(name="sessionFactory")
    private SessionFactory em;
    private static final Logger log = LogManager.getLogger();

    @Test
    public void test(){
      System.out.println((int)(Math.random()*1000000));


    }
    @Transactional
    @Test
    @Rollback(false)
    public void Usertest(){
        UserInfo userInfo;

        for(int i=2;i<10;i++){
            userInfo=new UserInfo();
            userInfo.setUid(i);
            userInfo.setName("努努"+i);
            userInfo.setPassword((int)(Math.random()*1000000)+"nunu");
            userInfo.setPhone((int)(Math.random()*1000000));
            userInfo.setEmail((int)(Math.random()*1000000)+"@qq.com");
            userInfo.setPhone((int)(Math.random()*100000000));
        baseDaoI.update(userInfo);
        }


    }
}
