package com.appcrews.javaee.maicai.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.baseService;
import com.appcrews.javaee.maicai.tool.FastjsonFilter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by micheal on 2017/8/25.
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class BaseAction <T>extends ActionSupport {
    private static final Logger logger = Logger.getLogger(BaseAction.class);
    protected PageInfo pageInfo=PageInfo.getPageInfo();
    protected T data;
    protected Json json;
    protected  int id;
    protected String sort;// 排序字段
    protected String order = "asc";// asc/desc
    protected baseService service;

    public void setService(baseService<T> service) {
        this.service = service;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * 获得response
     *
     * @return
     */
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * 获得session
     *
     * @return
     */
    public HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param includesProperties
     *            需要转换的属性
     * @param excludesProperties
     *            不需要转换的属性
     */
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
            logger.info("对象转JSON：要排除的属性[" + excludesProperties + "]要包含的属性["
                    + includesProperties + "]");
            String json;
            String User_Agent = getRequest().getHeader("User-Agent");
            if (StringUtils.indexOfIgnoreCase(User_Agent, "MSIE 6") > -1) {
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
            logger.info("转换后的JSON字符串：" + json);
            getResponse().setContentType("text/html;charset=utf-8");
            getResponse().getWriter().write(json);
            getResponse().getWriter().flush();
            getResponse().getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @throws IOException
     */
    public void writeJson(Object object) {
        writeJsonByFilter(object, null, null);
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param includesProperties
     *            需要转换的属性
     */
    public void writeJsonByIncludesProperties(Object object,
                                              String[] includesProperties) {
        writeJsonByFilter(object, includesProperties, null);
    }

    /**
     * 将对象转换成JSON字符串，并响应回前台
     *
     * @param object
     * @param excludesProperties
     *            不需要转换的属性
     */
    public void writeJsonByExcludesProperties(Object object,
                                              String[] excludesProperties) {
        writeJsonByFilter(object, null, excludesProperties);
    }
    /**
     * 保存一个对象
     */
    public void save() {
        Json json = new Json();
        if (data != null) {
            service.save(data);
            json.setSuccess(true);
            json.setMsg("新建成功！");
        }
        writeJson(json);
    }


    /**
     * 删除一个对象
     */
    public void delete() {
        Json json = new Json();
        if (!StringUtils.isBlank(id+"")) {
            T t = (T) service.getById(id);
            service.delete(t);
            json.setSuccess(true);
            json.setMsg("删除成功！");
        }
        writeJson(json);
    }

}
