
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
    <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
          rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="/js/arttemp.js"></script>
    <script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
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
                        商品
                        <small>所有商品</small>
                    </h1>
                </div>
                <table class="table table-striped table-bordered table-condensed">
                    <div class="search">
                            <input type="text" class="search_key" name="key" placeholder="菜名搜索"
                                   target="_blank"  ><button class="search_key2" >搜索</button>
                    </div>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>商品名</th>
                        <th>
                            <a  onclick="sortWare(1)"><i
                                    class="icon-arrow-up"></i> </a> <a
                                onclick="sortWare(0)"><i
                                class="icon-arrow-down icon-blue"></i> </a>价格
                        </th>
                        <th>图片</th>
                        <th>类型</th>
                        <th>标注</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                    <tbody id="box">
                    </tbody>
                </table>
                <div class="pagination">

                    <ul>
                        <li><a
                                 id="pr">Prev</a>
                        </li>
                        <li ><a >1</a></li>
                        <li><a
                                id="ne">Next</a>
                        </li>
                    </ul>
                </div>
                <div class="form-actions">
                    <a type="submit" class="btn btn-success btn-large"
                       href="<%=request.getContextPath()%>/data/insert_manage.html">添加</a>
                </div>
            </div>
        </div>
    </div>
    <hr>

    <%@ include file="/footer.jsp" %>
</div>
<script>
    var bar = document.getElementById("bar");
    var list = bar.getElementsByTagName("li");
    list[2].setAttribute("class", "active");
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
<script type="text/html" id="dataTemplate">
    {{each dataList as data index}}
    <tr class="middle-demo-1">

        <td>{{data.id}}</td>
        <td>{{data.name}}</td>
        <td>{{data.price}}RMB</td>
        <td>
            <div>
                <img height="100" width="200"
                     src="<%=request.getContextPath()%>/fileupload/{{data.img}}" onerror="this.src='<%=request.getContextPath()%>/fileupload/default.png'"/>
            </div>
        </td>
        <td>{{data.typeInfo.type}}</td>
        <td>{{data.remark}}</td>
        <td><a data-val="bj" data-index="{{index}}" data-id="{{data.id}}"><i
                class="icon-pencil"></i> 编辑</a>
            <a data-val="sc" data-index="{{index}}" data-id="{{data.id}}"><i
                    class="icon-trash"><s:token></s:token></i> 删除</a></td>
    </tr>
    {{/each }}
</script>
<script  src="/js/paging.js"></script>
<script type="application/javascript">
    var url="/data/queryWay_manage.html";
    var templ="dataTemplate"
    var page=1;
    var all;

    choose(page,url);
    sortWare=function (way) {
        $.ajax({
            url: url,
            type: "post",
            data: {sort: way,"PageInfo.pageNo":page},
            success: function (data) {
                console.log(data);
                var jsdata=JSON.parse(data);
                var data1 = {dataList: jsdata.datalist}
                var Str = template(templ, data1);
                $("#box").html(Str);
            }
        })
    }

</script>

<script src="/js/manage.js" >
</script>

</body>
</html>
