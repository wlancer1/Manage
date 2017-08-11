package com.appcrews.javaee.maicai;

import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.validation.BaseValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by micheal on 2017/8/9.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestVaild {
    @Autowired
    private BaseValidator baseValidator;
    private AdminInfo adminInfo;
    @Test
    public  void test(){

        adminInfo=new AdminInfo();
//        adminInfo.setPassword("13223");


        System.out.println(baseValidator.validateModel(adminInfo));
    }
}
