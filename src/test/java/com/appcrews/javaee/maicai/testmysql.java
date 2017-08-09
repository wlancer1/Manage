package com.appcrews.javaee.maicai;


import com.appcrews.javaee.maicai.dal.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by micheal on 2017/8/6.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testmysql{
    @Resource
    Admin admin;
    @Test
    public void test(){


        System.out.println(admin.sizeList().size());
//        System.out.println(admin.sizeList().size());

    }
}
