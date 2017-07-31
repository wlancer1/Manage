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

<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
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
							订单修改<small>订单号：<s:property value="#request.num" /></small>
						</h1>
					</div>
					<form action="<%=request.getContextPath()%>/order/save_order?onum=<s:property value="#request.num"/>" method="post">
					<div class="well-content"></div>
					<table
						class="table table-striped table-bordered table-hover datatable">
						<thead>
							<tr>
								<th>ID</th>
								<th>菜名</th>
								<th>单价</th>
								<th>数量</th>
								<th>选择</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.detailinfo" status="i">
								<tr>
									<td><s:property value="ID" /></td>
									<td><select onchange="showtable()" name="namelist[<s:property value="#i.index"/>]"
										style="WIDTH: 70px">
											<option selected="selected">
												<s:property value="name"/>
											</option>
											<s:iterator value="#request.nameinfo" status="index">
												<option>
													<s:property value="name" />
												</option>
											</s:iterator>
									</select></td>
									<td><s:property value="price" />RMB</td>
									<td><select onchange="showtable()" name="SCnumlist[<s:property value="#i.index"/>]"
										style="WIDTH: 50px">
										<option selected="selected">
													<s:property value="SCnum" />
												</option>
											<s:iterator value="new int[10]" status="index">
												<option>
													<s:property value="#index.index" />
												</option>
											</s:iterator>
									</select>
									<td><a
										href="<%=request.getContextPath()%>/order/delet_order.html.html?de=<s:property value="onum"/>&&scid=<s:property value="SCid"/>"><i
											class="icon-trash"></i>删除</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="form-actions">
						合计：
						<s:property value="#request.sum" />
						RMB
						<div class="ab">
							<input type="submit" class="btn btn-success btn-large"
									value="保存">
									<a href="<%=request.getContextPath()%>/order/query_order" >返回</a>
						</div>
					</div>
</form>
				</div>
			</div>
		</div>
	</div>
	<hr>


	<%@ include file="/footer.jsp"%>
	</div>


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
		var list=bar.getElementsByTagName("li");
		list[3].setAttribute("class","active");
	</script>
</body>
</html>
