




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
	<link href="<%=request.getContextPath()%>/css/jquery.dialogbox.css" rel="stylesheet">
	<script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
      <script src="/js/html5.js"></script>
	  <script src="/js/jquery-3.1.1.js"></script>
	  <script src="/js/jquery.dialogBox.js"></script>
	  <script src="/js/jquery.flot.js"></script>
</head>
<body>
<style type="text/css">
	*{ margin: 0; padding: 0; }
	dl{ font:12px normal; width: 900px; height: 100%; overflow: hidden; margin: 20px auto;  border:1px solid #eee; background: #f8f8f8; padding: 20px; }
	dl dt{ width: 100%; height: 30px; line-height: 30px; font-size: 14px; font-weight: bold; }
	dl dd{ padding: 10px; }
	pre{ color:#fff; height: 100%; overflow: hidden; background: #66BE8C; margin: 10px 0; word-break: normal; word-wrap:break-word;}
	code{ word-break: normal;}
	ul,li{ list-style: none; }
</style>
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
					<form class="form-horizontal" method="post" enctype="multipart/form-data" id="myform">
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
										<c:forEach items="${typeinfo}" var="typeList">
													<option  value="${typeList.typeid}">${typeList.type}</option>
										</c:forEach>
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
									value="提交"> <input type="reset" class="btn" value="重置"><div id="btn-dialogBox" style="display:none;"></div>
							</div>
							<div id="btn-dialogBox2" style="display:none;"></div>
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

<script type="application/javascript">

	$('form').submit(function() {
		$('#btn-dialogBox').dialogBox({
			hasClose: true,
			hasBtn: true,
			confirmValue: '确定',
			confirm: function(){

				$.ajax({
					cache: true,
					type: "POST",
					dataType:"json",
					url:"/data/save_manage.html",
					data:$('#myform').serialize(),// 你的formid
					async: false,
					success: function(data) {
						console.log(data);
						if(data.success)
						{
							console.log(12323);
							$('#btn-dialogBox2').dialogBox({
								content:'商品添加成功！',
								confirmValue: '确定', hasBtn: true
								,confirm:function () {
									window.location.href=" <%=request.getContextPath()%>/data/query_manage.html";
								}
							})
						}else if(data=="error"){
							$('#btn-dialogBox2').dialogBox({
								content:'商品添加失败！',
								confirmValue: '确定', hasBtn: true
								,confirm:function () {
									window.location.href=" <%=request.getContextPath()%>/data/query_manage.html";
								}
							})
						}
						<%--//                        $("#commonLayout_appcreshi").parent().html(data);--%>
					}
				});

			},
			cancelValue: '取消',
			title: '提示',
			content: '是否添加新的商品信息'
		});
		return false;
	});

</script>
</body>
</html>
