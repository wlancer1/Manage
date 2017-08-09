package com.appcrews.javaee.maicai;

import com.appcrews.javaee.maicai.model.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by micheal on 2017/8/9.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestVaild {
    private AdminInfo adminInfo;
    @Test
    public  void test(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        adminInfo=new AdminInfo();
        adminInfo.setPassword("13223");
        Set<ConstraintViolation<AdminInfo>> constraintViolations= validator.validate(adminInfo);

        System.out.println(constraintViolations);
    }
}
