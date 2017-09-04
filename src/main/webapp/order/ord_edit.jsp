




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <title><%=BaseConfig.getProjectName()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Admin panel developed with the Bootstrap from Twitter.">


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
							订单修改<small>订单号：<s:property value="#editDetail.onum" /></small>
						</h1>
					</div>
					<form action="<%=request.getContextPath()%>/order/save_order?id=<s:property value="#editDetail.onum" />" method="post">
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
						<tbody id="box">
							<s:iterator value="#request.editDetail.detailInfo" status="i">
								<tr>
									<td><s:property value="wareid" /></td>
									<td>
												<s:property value="wareInfo.name"/>
										</td>
									<td value="<s:property value="wareInfo.price" />"><s:property value="wareInfo.price" />RMB</td>
									<td><select onchange="showtable()"
										style="WIDTH: 50px">
										<option selected="selected">
													<s:property value="wareInfo.warenum" />
												</option>
											<s:iterator value="new int[10]" status="index">
												<option>
													<s:property value="#index.index" />
												</option>
											</s:iterator>
									</select></td>
									<td><a onclick="delet(<s:property value="wareid" />,<s:property value="#editDetail.onum" />)" ><i
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
<script type="application/javascript">
	delet=function (a,b) {
		$.ajax({
			url: "/order/delet_order.html",
			type: "post",
			dataType: "json",
			data: {onum: a,wareid:b},
			success: function (data) {
				if (data == "success") {
					document.getElementById('box').deleteRow(index);
					for(var i=1;i<=all;i++){
						$(".pagination ul li").eq(1).remove();
					}
				} else {
					alert("删除失败,你的商品在订单中");
				}

			}
		})
	}


</script>

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
