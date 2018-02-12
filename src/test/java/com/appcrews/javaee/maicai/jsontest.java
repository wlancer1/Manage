package com.appcrews.javaee.maicai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.tool.FastjsonFilter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by micheal on 2017/8/25.
 */
public class jsontest {

    @Test
    public void test(){
//        Json j=new Json();
//        j.setSuccess(true);
//        j.setMsg("成功");
//        writeJsonByFilter(j,null,null);

        String s="["+"{\"order\":[{\"fid\":10,\"img\":\"null\",\"name\":\"ewwqe\",\"price\":55,\"remark\":\"111\",\"type\":0,\"typeInfo\":{\"remark\":\"11\",\"type\":\"双子类\",\"typeid\":2},\"num\":2},{\"fid\":9,\"img\":\"\",\"name\":\"水果\",\"price\":15,\"remark\":\"111\",\"type\":0,\"typeInfo\":{\"remark\":\"11\",\"type\":\"双子类\",\"typeid\":2},\"num\":1}],\"uid\":\"1\"}"+"]";
//        s=s.substring(9,s.length()-1);


        JSONArray jsonArray = JSON.parseArray(s);//并将DS内容取出转为json数组
        System.out.println(jsonArray.getJSONObject(0).getString("order"));
//        for (int i = 0; i < jsonArray.size(); i++) {     //遍历json数组内容
//            JSONObject object = jsonArray.getJSONObject(i);
//            System.out.println(object.getString("fid")+"======"+object.getString("num"));
//
//        }

    }
    public void writeJsonByFilter(Object object, String[] includesProperties,
                                  String[] excludesProperties) {
        try {
            FastjsonFilter filter = new FastjsonFilter();// excludes优先于includes
            if (excludesProperties != null && excludesProperties.length > 0) {
                filter.getExcludes().addAll(
                        Arrays.<String> asList(excludesProperties));
            }
            if (includesProperties != null && includesProperties.length > 0) {
                filter.getIncludes().addAll(
                        Arrays.<String> asList(includesProperties));
            }
            String json;
//            String User_Agent = getRequest().getHeader("User-Agent");
            if (true) {
                // 使用SerializerFeature.BrowserCompatible特性会把所有的中文都会序列化为\\uXXXX这种格式，字节数会多一些，但是能兼容IE6
                json = JSON.toJSONString(object, filter,
                        SerializerFeature.WriteDateUseDateFormat,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.BrowserCompatible);
            } else {
                // 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd
                // hh24:mi:ss
                // 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
                json = JSON.toJSONString(object, filter,
                        SerializerFeature.WriteDateUseDateFormat,
                        SerializerFeature.DisableCircularReferenceDetect);
            }
           System.out.println("转换后的JSON字符串：" + json);
//            getResponse().setContentType("text/html;charset=utf-8");
//            getResponse().getWriter().write(json);
//            getResponse().getWriter().flush();
//            getResponse().getWriter().close();
        }catch (Exception e){

        }
    }
}
