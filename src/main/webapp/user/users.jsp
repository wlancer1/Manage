<%@ page import="com.appcrews.javaee.maicai.util.BaseConfig" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
    <title><%=BaseConfig.getProjectName()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">
<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="../js/html5.js"></script>
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
							用户 <small>所用用户</small>
						</h1>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>ID</th>
								<th>名字</th>
								<th>E-mail</th>
								<th>身份</th>
								<th>选择</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="userInfoList" status="index">
							<tr class="list-users">
								<td><s:property value="id"/></td>
								<td><s:property value="name" /></td>
								<td><s:property value="email" /></td>
								<td>
									<s:if test="power==1">
										卖家
									</s:if>
									<s:elseif test="power==2">
									买家
									</s:elseif>
								</td>
								<td>
									<div class="btn-group">
										<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown"
											href="#">Action.htmls <span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
											<li><a href="#"><i class="icon-trash"></i> Delete</a></li>
											<li><a href="#"><i class="icon-user"></i> Details</a></li>
											<li class="nav-header">Permissions</li>
											<li><a href="#"><i class="icon-lock"></i> Make <strong>Admin</strong></a></li>
											<li><a href="#"><i class="icon-lock"></i> Make <strong>Moderator</strong></a></li>
											<li><a href="#"><i class="icon-lock"></i> Make <strong>User</strong></a></li>
										</ul>
									</div>
								</td>
							</tr>
							</s:iterator>
							
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<li><a href="#">Prev</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<hr>

		<%@ include file="/footer.jsp"%>

	</div>
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
	<%--<script src="../js/bootstrap.min.js"></script>--%>
	<script src="../js/jquery-3.1.1.js"></script>
<script >
    var bar =document.getElementById("bar");
    var list=bar.getElementsByTagName("li");
    list[1].setAttribute("class","active");
</script>
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
