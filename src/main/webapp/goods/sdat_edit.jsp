<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
    <title><%=BaseConfig.getProjectName()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">


<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
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
							编辑商品 <small></small>
						</h1>
					</div>
					<form class="form-horizontal"
						action="<%=request.getContextPath()%>/data/edit_manage.html?id=<s:property value="#request.ts"/>"
						method="post" enctype="multipart/form-data">
						<s:token></s:token>
						<fieldset>
							<div class="control-group">
								<label class="control-label">商品名:</label>
								<div class="controls">
									<input class="input-xlarge" id="username" name="name"
										type="text" value="<s:property value="#request.wareinfo.name"/>" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">价格:</label>
								<div class="controls">
									<input  id="pass" name="price" type="text" value="<s:property value="#request.wareinfo.price"/>"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">上传图片:</label>
								<div class="controls">
									<input id="file" name="uploadImage" type="file" class="input-xlarge"  value="<s:property value="#request.wareinfo.img"/>"/>
								</div>
							</div>
							<div class="control-group">
									<label class="control-label">类型:</label><div class="controls">
									<select  onchange="showtable()" name="type">
										<c:forEach items="${typeinfo}" var="typeList">
											<c:choose>
												<c:when test="${typeList.typeid eq wareinfo.type}">
													<option selected="selected"  value="${typeList.typeid}">${typeList.type}</option>
												</c:when>
												<c:otherwise>
													<option value="${typeList.typeid}">${typeList.type}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>

							</div>
							
							<div class="control-group">
								<label class="control-label">标注:</label>
								<div class="controls">
									<input name="remark" class="input-xlarge" type="text" value="<s:property value="#request.wareinfo.remark"/>"/>
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
</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
</body>
</html>
