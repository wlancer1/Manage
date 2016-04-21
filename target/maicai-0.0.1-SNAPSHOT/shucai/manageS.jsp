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
							href="<%=request.getContextPath()%>/SCYH/query_YHAction">用户</a></li>
						<li class="active"><a
							href="<%=request.getContextPath()%>/SCGL/query_SCAction">蔬菜</a></li>
						<li><a
							href="<%=request.getContextPath()%>/SCDD/query_DDAction">订单</a></li>
						<li class="nav-header"><i class="icon-signal"></i> Statistics</li>
							<li><a href="<%=request.getContextPath()%>/SCGL/querytype_SCAction">添加蔬菜类型</a></li>
						<li><a href="#">Users</a></li>
						<li><a href="http://tongji.baidu.com/web/welcome/ico?s=bd50a33cf40f3755ca12255e905848cb">站长统计</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<li><a href="<%=request.getContextPath()%>/myprofile.jsp">个人中心</a></li>
						<li><a href="#">设置</a></li>
						<li><a
							href="<%=request.getContextPath()%>/SCDC/logout_DCAction">退出登陆</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							蔬菜 <small>所有蔬菜</small>
						</h1>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<div class="search">
						<form action="<%=request.getContextPath()%>/SCGL/search_SCAction.action?pagenow=<s:property value="#request.pagenow"/>" method="post" >
							<input type="text" class="search_key" name="key" placeholder="菜名搜索"
								target="_blank" value="<s:property value="#request.moren"/>"><input type="submit" class="search_key2"
								value="搜索">
								</form>
						</div>
						<thead>
							<tr>
								<th>ID</th>
								<th>菜名</th>
								<th><a href="<%=request.getContextPath()%>/SCGL/sort_SCAction.action?pagenow=<s:property value="#request.pagenow"/>&&target=up"><i
											class="icon-arrow-up"></i> </a> <a
										href="<%=request.getContextPath()%>/SCGL/sort_SCAction.action?pagenow=<s:property value="#request.pagenow"/>&&target=down"><i
											class="icon-arrow-down icon-blue"></i> </a>价格</th>
								<th>图片</th>
								<th>类型</th>
								<th>标注</th>
								<th>选择</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.shucaiinfo" status="index">
								<tr class="middle-demo-1">

									<td><s:property value="id" /></td>
									<td><s:property value="name" /></td>
									<td><s:property value="price" />RMB</td>
									<td><div>
											<img height="100" width="200"
												src="<%=request.getContextPath()%>/fileupload/<s:property value="img"/>"></img>
										</div></td>
									<td><s:property value="type" /></td>
									<td><s:property value="remark" /></td>
									<td><a
										href="<%=request.getContextPath()%>/SCGL/queryedit_SCAction.action?ts=<s:property value="id"/>"><i
											class="icon-pencil"></i> 编辑</a> <a
										href="<%=request.getContextPath()%>/SCGL/delet_SCAction.action?de=<s:property value="id"/>"><i
											class="icon-trash"></i> 删除</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="pagination">
						<%
							int i = 1;
						%>
						<ul>
							<li><a
								href="<%=request.getContextPath()%>/SCGL/query_SCAction.action?pagenow=<s:property value="#request.pagenow"/>&&flag=0">Prev</a></li>
							<s:iterator value="new int[#request.page]">
								<li><a
									href="<%=request.getContextPath()%>/SCGL/query_SCAction.action?pagenow=<%=i%>"><%=i++%></a></li>
							</s:iterator>
							<li><a
								href="<%=request.getContextPath()%>/SCGL/query_SCAction.action?pagenow=<s:property value="#request.pagenow"/>&&flag=1">Next</a></li>
						</ul>
					</div>
					<div class="form-actions">
						<a type="submit" class="btn btn-success btn-large"
							href="<%=request.getContextPath()%>/SCGL/insert_SCAction.action">添加</a>
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
