<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<title>订单</title>
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
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">

<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
	<div id="gh">
		<h1>结账明细单</h1>
	</div>
	<div class="span9">
		<div class="row-fluid">
			<div class="page-header" id="kj">
			<small>店名：<s:property value="#request.name" /></small>
			<br>
			<small>电话：<s:property value="#request.tele" /></small>
			<br>
				<small>订单号：<s:property value="#request.num" /></small>
				<br>
				<small>服务员：<s:property value="#session.myname" /></small>
				<br>
				<small>结账时间：<s:property value="#request.time" /></small>
			</div>
			<div class="well-content"></div>
			<table
				class="table table-striped table-bordered table-hover datatable">
				<thead id="bb">
					<tr>
						<th>ID</th>
						<th>菜名</th>
						<th>单价</th>
						<th>数量</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.detailinfo">
						<tr>
							<td><s:property value="ID" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="price" /></td>
							<td><s:property value="SCnum" /></td>

						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="form-actions" id="bb">
				合计：
				<s:property value="#request.sum" />
				RMB
				<div class="ab">
					<a onclick="javascript:window.print();">订单确认</a>
				</div>

			</div>
		</div>
	</div>
	</div>
	<hr>
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
