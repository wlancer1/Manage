package com.appcrews.javaee.maicai.tool;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by micheal on 2017/3/5.
 */
public class BaseConfig {
    public static  final String projectName="项目管理";
    public static  final String footerName="浙江大学城市学院";
    public static String getProjectName() {
        return projectName;
    }
    public  static void setHeader(HttpServletResponse r){
        r.setHeader("Access-Control-Allow-Origin", "http://localhost:10001");
         r.setHeader("Access-Control-Allow-Credentials","true");
        r.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");

    }
}
