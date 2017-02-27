<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Users | Strass</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">
<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
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
							value="#session.power"></s:property>:
						<s:property value="#session.myname"></s:property></a>
					
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
						<s:iterator value="#request.userinfo" status="index">
							<tr class="list-users">
								<td><s:property value="id"/></td>
								<td><s:property value="name" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="power" /></td>
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
