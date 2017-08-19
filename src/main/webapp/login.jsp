<!DOCTYPE html>
<html lang="en">
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%----%>
<%--<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>--%>
<head>
	<script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?bd50a33cf40f3755ca12255e905848cb";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();

	</script>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/css/style.css" />
	<link href='http://fonts.googleapis.com/css?family=Oleo+Script'
		  rel='stylesheet' type='text/css'>
	<script type="text/javascript"
			src="/js/jquery-3.1.1.js"></script>
	<script type="text/javascript"></script>
</head>
<body style="background: url('/img/bg1.jpg');">
<div class="ui-dialog" id="dialog" style="left: 40%;">

	<div class="lg-container" >
		<h1>Admin Area</h1>
		<form action="<%=request.getContextPath()%>/login/login_index.html"
			  id="lg-form" method="post">
			<c:out value="${Result.fail}"></c:out>
			<div>
				<label for="username">Username:</label> <input type="text"
															   name="account" id="username" placeholder="username" />
				<c:out value="${Result.account}"></c:out>
			</div>


			<div>
				<label for="password">Password:</label> <input type="password"
															   name="password" id="password" placeholder="password" />
				<c:out value="${Result.password}"></c:out>
			</div>
			<div>
				<button  id="login">Login</button>
			</div>

		</form>
		<div id="message">

		</div>

	</div>
</div>
<script>

    if(!${empty myname}){
        window.location.href="<%=request.getContextPath()%>/login/login_index.html";
    }
    $("#login").click(function () {

        $("#lg-form").submit();

    })

</script>
</body>
</html>
