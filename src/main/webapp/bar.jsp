<%--
  Created by IntelliJ IDEA.
  User: micheal
  Date: 2017/2/14
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<div class="span3">
    <div class="well sidebar-nav">
        <ul class="nav nav-list"  id="bar">
            <li class="nav-header"><i class="icon-wrench"></i>管理</li>
            <li><a href="<%=request.getContextPath()%>/user/query_user.html">用户</a></li>
            <li><a
                    href="<%=request.getContextPath()%>/data/query_manage.html">商品</a></li>
            <li><a href="<%=request.getContextPath()%>/order/query_order.html">订单</a></li>

            <li><a href="<%=request.getContextPath()%>/data/querytype_manage.html">添加商品类型</a></li>
            <li class="nav-header"><i class="icon-signal"></i>统计</li>
            <li><a href="#">Users</a></li>
            <li><a href="http://tongji.baidu.com/web/welcome/ico?s=bd50a33cf40f3755ca12255e905848cb"
                   target="view_window">站长统计</a></li>
            <li class="nav-header"><i class="icon-user"></i>设置</li>
            <li><a href="<%=request.getContextPath()%>/profile/myprofile.jsp">个人中心</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="<%=request.getContextPath()%>/logout/logout_logout.html">退出登陆</a></li>
        </ul>
    </div>
</div>
</html>
