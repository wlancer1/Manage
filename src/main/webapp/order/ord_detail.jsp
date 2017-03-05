
<%@ page import="com.appcrews.javaee.maicai.util.BaseConfig" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

	<title><%=BaseConfig.getProjectName()%></title>
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
<%@ include file="/head.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<%@ include file="/bar.jsp"%>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							订单详情 <small>订单号：<s:property value="#request.num"/></small>
						</h1>
					</div>
					<div class="well-content"></div>
					<table
						class="table table-striped table-bordered table-hover datatable">
						<thead>
							<tr>
								<th>ID</th>
								<th>菜名</th>
								<th>单价</th>
								<th>图片</th>
								<th>数量</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.detailinfo">
								<tr>
									<td><s:property value="ID"/></td>
									<td><s:property value="name"/></td>
									<td><s:property value="price"/></td>
									<td><div>
											<img height="100" width="200"
												src="<%=request.getContextPath()%>/fileupload/<s:property value="img"/>"></img>
										</div></td>
									<td><s:property value="SCnum"/></td>
								
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="form-actions">
						合计：<s:property value="#request.sum"/>RMB
					<div class="ab">
					<a href="<%=request.getContextPath()%>/SCDD/edit_DDAction.html?ts=<s:property
												value="#parameters.ts" />">修改</a>
					<a href="<%=request.getContextPath()%>/SCDD/query_DDAction.html">返回</a></div>
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
