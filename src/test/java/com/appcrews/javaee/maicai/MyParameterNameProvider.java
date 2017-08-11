package com.appcrews.javaee.maicai;

import javax.validation.ParameterNameProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by micheal on 2017/8/10.
 */
public class MyParameterNameProvider implements ParameterNameProvider {
    @Override
    public List<String> getParameterNames(Constructor<?> constructor) {
        return null;
    }

    @Override
    public List<String> getParameterNames(Method method) {
        return null;
    }
}
