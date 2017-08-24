<%--
  Created by IntelliJ IDEA.
  User: micheal
  Date: 2017/7/19
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>


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
    <link href="<%=request.getContextPath()%>/css/jquery.dialogbox.css" rel="stylesheet">
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
<%@ include file="/head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <%@ include file="/bar.jsp"%>
<div class="span9">
    <div class="row-fluid">
        <div class="page-header">
            <h1>编辑 <small>用户资料 修改</small></h1>
        </div>
        <form class="form-horizontal" method="post" enctype="multipart/form-data" id="myform">
            <s:token></s:token>
            <fieldset>
                <div class="control-group">
                    <label class="control-label" for="name">姓名</label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" id="name" value="${userinfo.name}" name="name"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="email" >E-mail</label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" id="email" value="${userinfo.email}" name="email" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="pnohe" >手机号</label>
                    <div class="controls">
                        <input type="number" class="input-xlarge" id="phone" value="${userinfo.phone}" name="phone"/>
                    </div>
                </div>
                <div class="form-actions">
                    <input type="submit" class="btn btn-success btn-large" value="保存修改" /> <div id="btn-dialogBox" style="display:none;"></div>
                    <a class="btn" href="history.go(-1)">取消</a>
                </div>
                <div id="btn-dialogBox2" style="display:none;"></div>
            </fieldset>
        </form>
    </div>
</div>
    </div>
            <%@ include file="/footer.jsp" %>
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
                    url:"/user/update_user.html?uuid=${uid}",
                    data:$('#myform').serialize(),// 你的formid
                    async: false,
                    success: function(data) {
                        if(data=="success")
                        {
                            $('#btn-dialogBox2').dialogBox({
                                content:'用户修改成功！',
                                confirmValue: '确定', hasBtn: true
                                ,confirm:function () {
                                    window.location.href="<%=request.getContextPath()%>/user/query_user.html";
                                }
                            })
                        }else if(data=="error1"){
                            $('#btn-dialogBox2').dialogBox({
                                content:'用户修改失败！',
                                confirmValue: '确定', hasBtn: true
                                ,confirm:function () {
                                    window.location.href="<%=request.getContextPath()%>/user/query_user.html";
                                }
                            })
                        }else if(data=="error2"){
                            $('#btn-dialogBox2').dialogBox({
                                content:'订单中有该用户，无法修改身份！',
                                confirmValue: '确定', hasBtn: true
                                ,confirm:function () {
                                    window.location.href="<%=request.getContextPath()%>/user/query_user.html";
                                }
                            })
                        }
<%--//                        $("#commonLayout_appcreshi").parent().html(data);--%>
                    }
                });

            },
            cancelValue: '取消',
            title: '提示',
            content: '是否确认修改该用户资料？'
            });
            return false;
        });

</script>
</body>
</html>
