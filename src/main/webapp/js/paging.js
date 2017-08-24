
choose=function (pa,url) {
    $(".pagination ul li").eq(page).removeClass("active");
    page=pa;
    $.ajax({
        url:url,
        type:"post",
        data:{"PageInfo.pageNo":page},
        success: function (data) {
            console.log(data);
            var jsdata=JSON.parse(data);
            var data1 = {dataList: jsdata.datalist}
            var Str = template(templ, data1);
            $("#box").html(Str);
           all=parseInt(jsdata.allpage);
            var temp="";
            for(var i=1;i<=all;i++){
                temp=temp+" <li><a onclick='choose("+i+",url)'>"+i
                    +"</a></li>";
            }
            $(".pagination ul li").eq(1).html(temp);
            $(".pagination ul li").eq(page+1).attr("class","active");

        }
    })

}
$("#pr").click(function () {
    $(".pagination ul li").eq(page).removeClass("active");
    if(page<=1)
        return;
    choose(--page,url);
});

$("#ne").click(function () {
    $(".pagination ul li").eq(page).removeClass("active");
    if(all<=page)
        return;
    choose(++page,url);
})