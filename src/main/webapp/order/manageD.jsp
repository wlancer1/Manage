<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->

</head>

<body>
<%@ include file="/head.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<%@ include file="/bar.jsp"%>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							订单 <small>所有订单</small>
						</h1>
					</div>
					<div class="well-content">
					</div>
						<table
							class="table table-striped table-bordered table-hover datatable">
							<thead>
								<tr>
									<th>订单号</th>
									<th>下单时间</th>
									<th>发货时间</th>
									<th>备注</th>
									<th>选择</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator value="#request.orderinfo" >
								<tr>
									<td><s:property value="onum"/></td>
									<td><s:property value="otime"/></td>
									<td><s:property value="Stime"/></td>
									<td><s:property value="oremark"/></td>
									<td><a
										href="<%=request.getContextPath()%>/SCDD/detailquery_DDAction.html?ts=<s:property
												value="onum" />"><i
											class="icon-book"></i> 详情</a> 
											<a
										href="<%=request.getContextPath()%>/SCDD/print_DDAction.html?ts=<s:property
												value="onum" />"><i
											class="icon-print"></i>打印订单</a> 
											<a
										href="<%=request.getContextPath()%>/SCDD/deletorder_DDAction.html?de=<s:property value="onum"/>"><i
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
								href="<%=request.getContextPath()%>/SCDD/query_DDAction.html?pagenow=<s:property value="#request.pagenow"/>&&flag=0">Prev</a></li>
							<s:iterator value="new int[#request.page]">
								<li><a
									href="<%=request.getContextPath()%>/SCDD/query_DDAction.html?pagenow=<%=i%>"><%=i++%></a></li>
							</s:iterator>
							<li><a
								href="<%=request.getContextPath()%>/SCDD/query_DDAction.html?pagenow=<s:property value="#request.pagenow"/>&&flag=1">Next</a></li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>
		<hr>

	<%@ include file="/footer.jsp"%>
	</div>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		var bar =document.getElementById("bar");
		var list=bar.getElementsByTagName("li");
		list[3].setAttribute("class","active");
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
