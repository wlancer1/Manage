<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
<title>Users | Strass</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">

<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
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
						<li><a href="http://tongji.baidu.com/web/welcome/ico?s=bd50a33cf40f3755ca12255e905848cb" target="view_window">站长统计</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<li><a href="my-profile.html">个人中心</a></li>
						<li><a href="#">设置</a></li>
						<li><a
							href="<%=request.getContextPath()%>/SCDC/logout_DCAction.html">退出登陆</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							添加蔬菜 <small></small>
						</h1>
					</div>
					<form class="form-horizontal"
						action="<%=request.getContextPath()%>/SCGL/save_SCAction.html"
						method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="control-group">
								<label class="control-label">菜名:</label>
								<div class="controls">
									<input class="input-xlarge" id="username" name="name"
										type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">价格:</label>
								<div class="controls">
									<input id="pass" name="price" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">上传图片:</label>
								<div class="controls">
									<input id="file" name="uploadImage" type="file"
										class="input-xlarge" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">类型:</label>
								<div class="controls">
									<select onchange="showtable()" name="type">
										<s:iterator value="#request.typeinfo" status="index">
											<option>
												<s:property value="type" />
											</option>
										</s:iterator>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">标注:</label>
								<div class="controls">
									<input name="remark" class="input-xlarge" type="text" />
								</div>
							</div>
							<div class="control-group"></div>
							<div class="form-actions">
								<input type="submit" class="btn btn-success btn-large"
									value="提交"> <input type="reset" class="btn" value="重置">
							</div>
						</fieldset>
					</form>

				</div>
			</div>
		</div>

		<hr>
		<div>
			<%@ include file="/footer.jsp"%>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>
