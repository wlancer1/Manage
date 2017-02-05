<%@page import="com.appcrews.javaee.maicai.service.YHAction" %>
<%@page import="com.appcrews.javaee.maicai.service.DDAction" %>
<%@page import="com.appcrews.javaee.maicai.service.SCAction" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?bd50a33cf40f3755ca12255e905848cb";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

    <meta charset="utf-8">
    <title>Admin | Strass</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description"
          content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <%
        SCAction S = new SCAction();
        int size = S.size();
        DDAction d = new DDAction();
        int size2 = d.size();
        YHAction b = new YHAction();
        int size3 = b.size();

    %>
    <script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
</head>

<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </a> <a class="brand" href="#">Strass Administration</a>
            <div class="btn-group pull-right">
                <a class="btn" href="#"><i class="icon-user"></i> <s:property
                        value="#session.power"></s:property>:
                    <s:property value="#session.myname"></s:property></a>

            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href="#">主页</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">用户 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="new-user.html">New User</a></li>
                            <li class="divider"></li>
                            <li><a href="users.jsp">Manage Users</a></li>
                        </ul>
                    </li>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header"><i class="icon-wrench"></i>管理</li>
                    <li><a href="<%=request.getContextPath()%>/SCYH/query_YHAction">用户</a></li>
                    <li><a
                            href="<%=request.getContextPath()%>/SCGL/query_SCAction">蔬菜</a></li>
                    <li><a href="<%=request.getContextPath()%>/SCDD/query_DDAction">订单</a></li>
                    <li class="nav-header"><i class="icon-signal"></i> Statistics</li>
                    <li><a href="<%=request.getContextPath()%>/SCGL/querytype_SCAction">添加蔬菜类型</a></li>
                    <li><a href="#">Users</a></li>
                    <li><a href="http://tongji.baidu.com/web/welcome/ico?s=bd50a33cf40f3755ca12255e905848cb"
                           target="view_window">站长统计</a></li>
                    <li class="nav-header"><i class="icon-user"></i> Profile</li>
                    <li><a href="<%=request.getContextPath()%>/myprofile.jsp">个人中心</a></li>
                    <li><a href="#">设置</a></li>
                    <li><a href="<%=request.getContextPath()%>/SCDC/logout_DCAction">退出登陆</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <div class="well hero-unit">
                <h1>
                    Welcome,
                    <s:property value="#session.myname"/>
                </h1>
                <p>
                    <a class="btn btn-success btn-large" href="<%=request.getContextPath()%>/SCYH/query_YHAction">Manage
                        Users &raquo;</a>
                </p>
            </div>

            <div class="row-fluid">
                <div class="page-header">
                    <h1>
                        统计
                        <small>Approve or Reject</small>
                    </h1>
                </div>
                <div class="row-fluid">
                    <div class="span3">
                        <h3>用户数量</h3>
                        <p>
                            <a href="<%=request.getContextPath()%>/SCYH/query_YHAction"
                               class="badge badge-inverse"><%=size3%>
                            </a>
                        </p>
                    </div>
                    <div class="span3">
                        <h3>蔬菜数量</h3>
                        <p>
                            <a href="<%=request.getContextPath()%>/SCGL/query_SCAction"
                               class="badge badge-inverse"><%=size%>
                            </a>
                        </p>
                    </div>
                    <div class="span3">
                        <h3>订单</h3>
                        <p>
                            <a href="<%=request.getContextPath()%>/SCDD/query_DDAction"
                               class="badge badge-inverse"><%=size2%>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <hr>

    <footer class="well" id="gh"> &copy; <a target="_blank">浙江商业职业技术学院</a>
        <span id="busuanzi_container_site_pv" style="display: inline;">本站总访问量<span id="busuanzi_value_site_pv"></span>次</span>
        <span id="busuanzi_container_site_uv" style="display: inline;">
    访客数<span id="busuanzi_value_site_uv"></span>人次</span>
    </footer>

</div>


<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
