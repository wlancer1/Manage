<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <title>Users | Strass</title>
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
                        蔬菜
                        <small>所有蔬菜</small>
                    </h1>
                </div>
                <table class="table table-striped table-bordered table-condensed">
                    <div class="search">
                        <form action="<%=request.getContextPath()%>/SCGL/search_SCAction.html?pagenow=<s:property value="#request.pagenow"/>"
                              method="post">
                            <input type="text" class="search_key" name="key" placeholder="菜名搜索"
                                   target="_blank" value="<s:property value="#request.moren"/>"><input type="submit"
                                                                                                       class="search_key2"
                                                                                                       value="搜索">
                        </form>
                    </div>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>菜名</th>
                        <th>
                            <a href="<%=request.getContextPath()%>/SCGL/sort_SCAction.html?pagenow=<s:property value="#request.pagenow"/>&&target=up"><i
                                    class="icon-arrow-up"></i> </a> <a
                                href="<%=request.getContextPath()%>/SCGL/sort_SCAction.html?pagenow=<s:property value="#request.pagenow"/>&&target=down"><i
                                class="icon-arrow-down icon-blue"></i> </a>价格
                        </th>
                        <th>图片</th>
                        <th>类型</th>
                        <th>标注</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                    <tbody id="box">
                    <%--<s:iterator value="#request.shucaiinfo" status="index">--%>

                    <%--</s:iterator>--%>
                    </tbody>
                </table>
                <div class="pagination">
                    <%
                        int i = 1;
                    %>
                    <ul>
                        <li><a
                                 id="pr">Prev</a>
                        </li>
                        <s:iterator value="new int[#request.allpage]">
                            <li><a
                                    href="#"><%=i++%>
                            </a></li>
                        </s:iterator>
                        <li><a
                                id="ne">Next</a>
                        </li>
                    </ul>
                </div>
                <div class="form-actions">
                    <a type="submit" class="btn btn-success btn-large"
                       href="<%=request.getContextPath()%>/SCGL/insert_SCAction.html">添加</a>
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
<script type="application/javascript">
    var page=1;
    var all=${allpage};
    $("#pr").click(function () {
        if(page<=1)
        return;
        $.ajax({
            url:"/SCGL/fanye_SCAction.html",
            type:"post",
            data:{pageNo:--page},
            success: function (data) {
                console.log(data);
                var data1 = {dataList: data}
                var Str = template("dataTemplate", data1);
                console.log(Str);
                $("#box").html(Str);

            }
        })
        });
    $("#ne").click(function () {
        if(all<=page)
            return;
        $.ajax({
            url:"/SCGL/fanye_SCAction.html",
            type:"post",
            data:{pageNo:--page},
            success: function (data) {
                console.log(data);
                var data1 = {dataList: data}
                var Str = template("dataTemplate", data1);
                $("#box").html(Str);

            }
        })

    })
    init();
    function init() {
        $.ajax({
            url: "/SCGL/initquery_SCAction.html",
            type: "post",
            data: {pageNo: page},
            success: function (data) {

                var jsdata=JSON.parse(data);
                var data1 = {dataList: jsdata.datalist}

                var Str = template("dataTemplate", data1);
                $("#box").html(Str);

            }
        })

    }
    $("#box").on("click", "a", function () {

        var box = document.getElementById("box");
        var trlist = box.getElementsByTagName("tr");
        var alist;
        for (var i = 0; i < trlist.length; i++) {
            alist = trlist[i].getElementsByTagName("a");
            for (var j = 0; j < alist.length; j++) {
                alist[j].setAttribute("data-index", "" + i);
            }
        }
        var choose = $(this).attr('data-val');
        var id = parseInt($(this).attr('data-id'));
        var index = parseInt($(this).attr('data-index'));

        console.log(index + "=========" + j);
        if (choose == "bj") {

        } else {

            $.ajax({
                url: "/SCGL/delet_SCAction.html",
                type: "post",
                data: {de: id},
                success: function (data) {
                    console.log(data);
                    if (data == "success") {
                        document.getElementById('box').deleteRow(index);
                    } else {
                        alert("删除失败,你的蔬菜在订单中");
                    }

                }
            })
        }

    })
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
        <td>{{data.type}}</td>
        <td>{{data.remark}}</td>
        <td><a data-val="bj" data-index="{{index}}" data-id="{{data.id}}"><i
                class="icon-pencil"></i> 编辑</a>
            <a data-val="sc" data-index="{{index}}" data-id="{{data.id}}"><i
                    class="icon-trash"></i> 删除</a></td>
    </tr>
    {{/each }}
</script>
</body>
</html>
