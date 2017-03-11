<!DOCTYPE HTML>
<html lang="en-US">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<script type="text/javascript">
	
</script>
</head>
<body
	style="background: url(<%=request.getContextPath()%>/img/bg1.jpg);">
	
	<div class="lg-container">
		<h1>Admin Area</h1>
		<s:fielderror />
		<form action="<%=request.getContextPath()%>/login/login_index.html"
			id="lg-form" method="post">

			<div>
				<label for="username">Username:</label> <input type="text"
					name="account" id="username" placeholder="username" />
			</div>

			<div>
				<label for="password">Password:</label> <input type="password"
					name="password" id="password" placeholder="password" />
			</div>
			<div>
				<button  id="login">Login</button>
			</div>
			
		</form>
		<div id="message">
		
		</div>
		
	</div>

			<div class="kuang"><img
						src="<%=request.getContextPath()%>/img/ziti.png" style="width: 300px"></div>
<script>

if(!${empty myname}){
	window.location.href="<%=request.getContextPath()%>/login/login_index.html";
}
			$("#login").click(function () {
				var myArray=new Array();
				var password=document.getElementById("password").value;
				var username=document.getElementById("username").value;
				myArray[0]=username;
				myArray[1]=password;
				if(password!=""&&username!=""&&getCookie("loginInfo")==null){
					SetCookie("loginInfo",myArray);
					$("#lg-form").submit();
				}else{
					alert("账号密码不能为空！！");
				}

		})

		function getCookie(name)//取cookies函数
		{
			var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
			if(arr != null) return (arr[2]); return null;
		}
	function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
	{
		var exp  = new Date();    //new Date("December 31, 9998");
		exp.setTime(exp.getTime() + 900000);
		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	}
</script>
</body>
</html>