
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <title><%=BaseConfig.getProjectName()%>
    </title>
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
    <script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
    <script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
</head>

<body>
<%@ include file="/head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@ include file="/bar.jsp" %>
        <div class="span9">
            <div class="row-fluid">
                <div class="page-header">
                    <h1>
                        订单详情
                        <small>订单号：${OrderDetail.onum}</small>
                    </h1>
                </div>
                <div class="well-content"></div>
                <table
                        class="table table-striped table-bordered table-hover datatable">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>菜名</th>
                        <th>单价</th>
                        <th>图片</th>
                        <th>数量</th>
                    </tr>
                    </thead>
                    <tbody id="detail">
                    <c:forEach items="${OrderDetail.detailInfo}" var="detailSet">
                        <tr price="${detailSet.wareInfo.price}" num="${detailSet.warenum}">
                            <td>${detailSet.wareid}</td>
                            <td>${detailSet.wareInfo.name}</td>
                            <td>${detailSet.wareInfo.price}</td>
                            <td>
                                <div>
                                    <img height="100" width="200"
                                         src="<%=request.getContextPath()%>/fileupload/${detailSet.wareInfo.img}"
                                         onerror="this.src='<%=request.getContextPath()%>/fileupload/default.png'"/>
                                </div>
                            </td>
                            <td>${detailSet.warenum}</td>

                        </tr>
                   </c:forEach>
                    </tbody>
                </table>
                <div class="form-actions">
                    <p style="float: left"></p>
                    <div class="ab">
                        <a href="<%=request.getContextPath()%>/order/edit_order.html?id=<s:property
									value="#parameters.ts" />">修改</a>
                        <a href="<%=request.getContextPath()%>/order/query_order.html">返回</a></div>
                </div>

            </div>
        </div>
    </div>
</div>
<hr>
<%@ include file="/footer.jsp" %>
</div>

<script type="application/javascript">
    var box = document.getElementById('detail');
    var sum = 0;
    var list = box.getElementsByTagName('tr');
    for (var i = 0; i < list.length; i++) {
        var price = list[i].getAttribute('price');
        var num = list[i].getAttribute('num');
        sum += price * num;
    }
    $('.form-actions p').text("合计："+sum+" RMB");


</script>


<script src="js/bootstrap.min.js"></script>
<script>
    var list = bar.getElementsByTagName("li");
    list[3].setAttribute("class", "active");
    $(document).ready(function () {
        $('.dropdown-menu li a').hover(function () {
            $(this).children('i').addClass('icon-white');
        }, function () {
            $(this).children('i').removeClass('icon-white');
        });

        if ($(window).width() > 760) {
            $('tr.list-users td div ul').addClass('pull-right');
        }
    });
</script>
</body>
</html>
