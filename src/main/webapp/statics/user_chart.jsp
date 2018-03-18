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
    <!--[if lt IE 9]>
    <script src="/js/html5.js"></script>
    <![endif]-->
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script src="/js/highcharts.js"></script>
    <script src="/js/exporting.js"></script>
    <script async="" src="https://dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
</head>
<body>
<%@ include file="/head.jsp"%>
<div class="container-fluid">
    <div class="row-fluid">
        <%@ include file="/bar.jsp"%>
        <div class="span9">
            <div id="container" style="min-width:400px;height:400px" ></div>
        </div>
    </div>

    <hr>
    <%@ include file="/footer.jsp"%>

</div>
<script>
    var bar = document.getElementById("bar");
    var list = bar.getElementsByTagName("li");
    list[6].setAttribute("class", "active");
    var sj=[['买家',${buyer}], ['卖家',${seller}]];

    $(function () {
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '无店铺的用户数和有店铺的用户数 占比'
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '用户比例',
                data: sj
            }]
        });
    });
    </script>
</body>
</html>
