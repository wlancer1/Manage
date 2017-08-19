<!DOCTYPE HTML>
<html lang="en-US">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>添加</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<s:if test="#request.flag!=null">
 <script>   
 alert("保存成功");
this.window.opener = null;   
window.close();
 history.go(0);
 </script>
</s:if>
<form action="<%=request.getContextPath()%>/data/inserttype_manage.html"
			id="lg-form" method="post">
<div>
				<label for="username">类别:</label> <input type="text"
					name="type" id="username" placeholder="类型" />
			</div>
			<div>
				<button type="submit" id="login">保存</button>
			</div>
				</form>
</body>
</html>