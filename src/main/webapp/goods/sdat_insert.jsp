
<%@ page import="com.appcrews.javaee.maicai.tool.BaseConfig" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
    <title><%=BaseConfig.getProjectName()%></title>
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
			<%@ include file="/bar.jsp" %>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							添加商品 <small></small>
						</h1>
					</div>
					<form class="form-horizontal"
						action="<%=request.getContextPath()%>/data/save_manage.html"
						method="post" enctype="multipart/form-data">
						<s:token></s:token>
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
