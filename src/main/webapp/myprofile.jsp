<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<title>Users | Strass</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">

<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
	rel="stylesheet">
<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->

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
							</ul></li>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header"><i class="icon-wrench"></i> 管理</li>
						<li><a
							href="<%=request.getContextPath()%>/SCYH/query_YHAction.html">用户</a></li>
						<li ><a
							href="<%=request.getContextPath()%>/SCGL/query_SCAction.html">蔬菜</a></li>
						<li><a
							href="<%=request.getContextPath()%>/SCDD/query_DDAction.html">订单</a></li>
						<li class="nav-header"><i class="icon-signal"></i> Statistics</li>
						<li><a href="<%=request.getContextPath()%>/SCGL/querytype_SCAction">添加蔬菜类型</a></li>
						<li><a href="#">Users</a></li>
					<li><a href="http://tongji.baidu.com/web/welcome/ico?s=bd50a33cf40f3755ca12255e905848cb" target="view_window">站长统计</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<li class="active"><a href="#">个人中心</a></li>
						<li><a href="#">设置</a></li>
						<li><a
							href="<%=request.getContextPath()%>/SCDC/logout_DCAction.html">退出登陆</a></li>
					</ul>
				</div>
			</div>
			  <div class="span9">
		  <div class="row-fluid">
			<div class="page-header">
				<h1>个人中心 <small>更新 信息</small></h1>
			</div>
			<form class="form-horizontal">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name">Name</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="name" value="Admin" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">E-mail</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="email" value="travis@provider.com" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="pnohe">Phone</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="phone" value="xxx-xxx-xxxx" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="city">City</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="city" value="My City" />
						</div>
					</div>	
					<div class="control-group">
						<label class="control-label" for="role">Role</label>
						<div class="controls">
							<select id="role">
								<option value="admin" selected>Admin</option>
								<option value="mod">Moderator</option>
								<option value="user">User</option>
							</select>
						</div>
					</div>	
					<div class="control-group">
						<label class="control-label" for="active">Active?</label>
						<div class="controls">
							<input type="checkbox" id="active" value="1" checked />
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" class="btn btn-success btn-large" value="Save Changes" /> <a class="btn" href="users.html">Cancel</a>
					</div>					
				</fieldset>
			</form>
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
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.dropdown-menu li a').hover(function() {
				$(this).children('i').addClass('icon-white');
			}, function() {
				$(this).children('i').removeClass('icon-white');
			});

			if ($(window).width() > 760) {
				$('tr.list-users td div ul').addClass('pull-right');
			}
		});
	</script>
</body>
</html>
