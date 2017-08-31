





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
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
	rel="stylesheet">
<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
<!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="/js/arttemp.js"></script>
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
							订单 <small>所有订单</small>
						</h1>
					</div>
					<div class="well-content">
					</div>
						<table
							class="table table-striped table-bordered table-hover datatable">
							<thead>
								<tr>
									<th>订单号</th>
									<th>下单时间</th>
									<th>发货时间</th>
									<th>备注</th>
									<th>选择</th>
								</tr>
							</thead>
							<tbody id="box">
								
							</tbody>
						</table>
						<div class="pagination">
						<ul>
							<li><a
							>Prev</a></li>

								<li><a
									>1</a></li>
							<li><a>Next</a></li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>
		<hr>

	<%@ include file="/footer.jsp"%>
	</div>
<script type="application/javascript"  src="/js/paging.js">

</script>
	<script>
		var bar =document.getElementById("bar");
		var list=bar.getElementsByTagName("li");
		list[3].setAttribute("class","active");
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
		var url="/order/queryWay_order.html";
		var templ="orderTemplate"
		var page=1;
		var all;

		choose(page,url);
	</script>

<script type="text/html" id="orderTemplate">
	{{each dataList as data index}}
	<tr>
		<td>{{data.onum}}</td>
		<td>{{data.otime}}</td>
		<td>{{data.stime}}</td>
		<td>{{data.oremark}}</td>
		<td><a
				href="<%=request.getContextPath()%>/order/detailquery_order.html?id={{data.onum}}"><i
				class="icon-book"></i> 详情</a>
			<a
					href="<%=request.getContextPath()%>/order/print_order.html?id={{data.onum}}>">
					<i
					class="icon-print"></i>打印订单</a>
			<a
					href="<%=request.getContextPath()%>/order/deletorder_order.html?id={{data.onum}}"/>"<i
					class="icon-trash"></i> 删除</a>
		</td>
	</tr>
	{{/each }}
</script>
</body>
</html>
