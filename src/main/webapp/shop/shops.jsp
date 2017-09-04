
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><%=BaseConfig.getProjectName()%></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description"
          content="Admin panel developed with the Bootstrap from Twitter.">

    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/site.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="/js/arttemp.js"></script>
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
                        商铺 <small>所用商铺</small>
                    </h1>
                </div>
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>sid</th>
                        <th>商铺名称</th>
                        <th>开店用户</th>
                        <th>开店时间</th>
                        <th>状态</th>
                        <th>简单描述</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                    <tbody id="box">
                    </tbody>
                </table>
                <div class="pagination">
                    <ul>
                        <li><a id="pr" >Prev</a></li>
                        <li class="active"><a >1</a></li>
                        <li><a id="ne">Next</a></li>
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
<script type="application/javascript" src="/js/paging.js"></script>
<script >
    var bar =document.getElementById("bar");
    var list=bar.getElementsByTagName("li");
    list[4].setAttribute("class","active");
    var url="/shop/queryWay_shop.html";
    var page=1;
    var templ="ShopTemplate";

    choose(page,url);
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
<script type="text/html" id="ShopTemplate">
    {{each dataList as data index}}
    <tr class="list-users">
        <td>{{data.sid}}</td>
        <td>{{data.name}}</td>
        <th>{{data.userInfo.name}} </th>
        <td>{{data.time}}</td>
        <td>{{if data.status==1}}
            <span class="label label-important">Inactive</span>
            {{else}}
            <span class="label label-success">Active</span>
            {{/if}}
        </td>
        <th>{{data.description}}</th>
        <td>
            <div class="btn-group">
                <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" >Actions <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a  data-val="bj"  data-id="{{data.uid}}"  ><i class="icon-pencil"></i> 编辑</a></li>
                    <li><a  data-val="sc"  data-id="{{data.uid}}"  ><i class="icon-trash"></i> 删除</a></li>
                    <li><a data-val="xq"  data-id="{{data.uid}}"  ><i class="icon-user"></i> 详情</a></li>
                    <li class="nav-header">Permissions</li>
                    <li><a data-val="up_saler"  data-id="{{data.uid}}"  ><i class="icon-lock"></i> 成为 <strong>买家</strong></a></li>
                    <li><a data-val="up_buyer"  data-id="{{data.uid}}"  ><i class="icon-lock"></i> 成为 <strong>卖家</strong></a></li>
                </ul>
            </div>
        </td>
    </tr>
    {{/each }}
</script>
</body>
</html>
