package com.appcrews.javaee.maicai.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Created by micheal on 2017/8/10.
 */
@Component
public class BaseValidator{
    public   Map validateModel(Object obj) { //验证某一个对象
        Map map=new HashMap<String,String>();
        StringBuffer buffer = new  StringBuffer( 64 ); //用于存储验证后的错误信息

        Validator validator = Validation.buildDefaultValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(obj);//验证某个对象,，其实也可以只验证其中的某一个属性的

        Iterator<ConstraintViolation<Object>> iter = constraintViolations
                .iterator();
        while  (iter.hasNext()) {
            ConstraintViolation c=iter.next();
            String key=c.getPropertyPath().toString();
            String message = c.getMessage();
            map.put(key,message);
        }
        return  map;

    }
}
