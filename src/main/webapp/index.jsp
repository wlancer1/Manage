<%@ page import="com.appcrews.javaee.maicai.util.BaseConfig" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title><%=BaseConfig.getProjectName()%></title>
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
    <script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
</head>

<body>

<%@ include file="/head.jsp"%>
<div class="container-fluid">
    <div class="row-fluid">
        <%@ include file="/bar.jsp"%>
        <div class="span9">
            <div class="well hero-unit">
                <h1>
                    Welcome,
                    <s:property value="#session.myname"/>
                </h1>
                <p>
                    <a class="btn btn-success btn-large" href="<%=request.getContextPath()%>/user/query_YHAction.html">管理用户 &raquo;</a>
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
                            <a href="<%=request.getContextPath()%>/user/query_YHAction.html"
                               class="badge badge-inverse">${sizelist[0]}
                            </a>
                        </p>
                    </div>
                    <div class="span3">
                        <h3>商品数量</h3>
                        <p>
                            <a href="<%=request.getContextPath()%>/data/query_manage.html"
                               class="badge badge-inverse">${sizelist[1]}
                            </a>
                        </p>
                    </div>
                    <div class="span3">
                        <h3>订单</h3>
                        <p>
                            <a href="<%=request.getContextPath()%>/order/query_order.html"
                               class="badge badge-inverse">${sizelist[2]}
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <hr>
    <%@ include file="/footer.jsp"%>

</div>


<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
