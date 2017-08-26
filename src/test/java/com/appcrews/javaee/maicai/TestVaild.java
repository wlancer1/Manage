package com.appcrews.javaee.maicai;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.model.base.AdminInfo;
import com.appcrews.javaee.maicai.validation.BaseValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by micheal on 2017/8/9.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestVaild {
    @Autowired
    BaseDaoI baseDaoI;
    @Autowired
    private BaseValidator baseValidator;
    private AdminInfo adminInfo;
    @Transactional
    @Test
    public  void test(){

        adminInfo=new AdminInfo();
//        adminInfo.setPassword("13223");
        adminInfo.setPassword("1232");
        adminInfo.setAccount("wyh");
        adminInfo.setPower(1);
        baseDaoI.save(adminInfo);
        System.out.println(baseValidator.validateModel(adminInfo));
    }
}
