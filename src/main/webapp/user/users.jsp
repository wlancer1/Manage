<%@ page import="com.appcrews.javaee.maicai.tool.BaseConfig" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
    <title><%=BaseConfig.getProjectName()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">
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
								<th>手机号</th>
								<th>E-mail</th>
								<th>身份</th>
								<th>状态</th>
								<th>选择</th>
							</tr>
						</thead>
						<tbody id="box">
						<s:iterator value="userInfoList" status="index">
							<tr class="list-users">
								<td><s:property value="id"/></td>
								<td><s:property value="name" /></td>
								<th><s:property value="phone"/> </th>
								<td><s:property value="email" /></td>
								<td>
									<s:if test="power==1">
										卖家
									</s:if>
									<s:elseif test="power==2">
									买家
									</s:elseif>
								</td>
								<td><s:if test="status==0">
									<span class="label label-important">Inactive</span></s:if>
									<s:elseif test="status==1">
										<span class="label label-success">Active</span>
									</s:elseif>
								</td>
								<td>
									<div class="btn-group">
										<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" >Actions <span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a  data-val="bj"  data-id="${id}"  ><i class="icon-pencil"></i> 编辑</a></li>
											<li><a  data-val="sc"  data-id="${id}"  ><i class="icon-trash"></i> 删除</a></li>
											<li><a data-val="xq"  data-id="${id}"  ><i class="icon-user"></i> 详情</a></li>
											<li class="nav-header">Permissions</li>
											<li><a data-val="up_manger"  data-id="${id}"  ><i class="icon-lock"></i> 成为 <strong>管理</strong></a></li>
											<li><a data-val="up_saler"  data-id="${id}"  ><i class="icon-lock"></i> 成为 <strong>买家</strong></a></li>
											<li><a data-val="up_buyer"  data-id="${id}"  ><i class="icon-lock"></i> 成为 <strong>卖家</strong></a></li>
										</ul>
									</div>
								</td>
							</tr>
							</s:iterator>
							
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<li><a >Prev</a></li>
							<li class="active"><a >1</a></li>
							<li><a >Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<hr>

		<%@ include file="/footer.jsp"%>

	</div>
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
<script src="../js/jquery-3.1.1.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script >
    var bar =document.getElementById("bar");
    var list=bar.getElementsByTagName("li");
    list[1].setAttribute("class","active");
    $("#box").on("click","a",function () {
        var choose = $(this).attr('data-val');
        var id = parseInt($(this).attr('data-id'));
        switch(choose){
			case "bj":
			  window.location.href="<%=request.getContextPath()%>/user/queryedit_user.html?uid="+id;
			    break;
			case "sc":
                console.log("sc"+id);
			    break;
            case "xq":
                console.log("xq"+id);
                break;
            case "up_manger":
                console.log("up"+id);
                break;
            case "up_buyer":
                console.log("upm"+id);
                break;
            case "up_saler":
                console.log("ups"+id);
                break;
		}


    })
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
