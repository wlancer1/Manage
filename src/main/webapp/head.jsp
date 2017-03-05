<%--
  Created by IntelliJ IDEA.
  User: micheal
  Date: 2017/2/26
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </a> <a class="brand" href="#">ZUCC</a>
            <div class="btn-group pull-right">
                <a class="btn" href="#"><i class="icon-user"></i> <s:property
                        value="#session.power"></s:property>: <s:property
                        value="#session.myname"></s:property></a>

            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href="../index.jsp">主页</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">用户 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="new-user.html">New User</a></li>
                            <li class="divider"></li>
                            <li><a href="users.jsp">Manage Users</a></li>
                        </ul>
                    </li>
                    </ul>
            </div>
        </div>
    </div>
</div>
</html>
