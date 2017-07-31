
<%@ page import="com.appcrews.javaee.maicai.tool.BaseConfig" %>
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
		
	<script src="js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->

</head>
<script>
function openLogin(){
	window.open ("<%=request.getContextPath()%>/addtype.jsp",'newwindow','height=200,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}

</script>
<body>
<%@ include file="/head.jsp"%>

	<div class="container-fluid">
		<div class="row-fluid">
			<%@ include file="/bar.jsp"%>
			<div class="row-fluid">
	<div class="control-group" id="gh">
		<label class="control-label"><h1>已有类型:</h1></label>
		<div class="controls">
			<select onchange="showtable()" name="type">
				<s:iterator value="#request.typeinfo" status="index">
					<option>
						<s:property value="type" />
					</option>
				</s:iterator>
			</select>
			<a href="javascript:void(0)" onclick="openLogin();"><i class="icon-pencil"></i>添加</a>
		</div>
		
	</div>
</div>
</div>
		<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
		<%@ include file="/footer.jsp"%>

	</div>
<script>
    var bar =document.getElementById("bar");
    var list=bar.getElementsByTagName("li");
    list[4].setAttribute("class","active");
</script>
	
</body>
</html>