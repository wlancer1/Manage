


   //分页
   //搜索
   var search=document.getElementsByClassName('search_key2')[0];
   search.onclick=function () {
       var detail=$(".search_key").val();
       console.log(detail);
       if(detail!="")
       {
           $.ajax({
               url:"/data/search_manage.html",
               type:"post",
               dataType: "json",
               data:{key:detail},
               success: function (data) {
                   console.log(data);
                   var map=data.obj;
                   if(map.datalist==null)
                       alert("没有该名称的数据");
                   else{
                       var data1 = {dataList: map.datalist}
                       var Str = template("dataTemplate", data1);
                       $("#box").html(Str);
                   }
               }
           })
           var temp;
           for(var i=1;i<=all;i++){
               temp=temp+" <li><a onclick='choose("+i+",url)'>"+i
                   +"</a></li>";
           }
           $(".pagination ul li").eq(1).html(temp);

       }else
       {
           for(var i=1;i<=all;i++){
               $(".pagination ul li").eq(1).remove();
           }
           init();
       }
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

    if (choose == "bj") {
       window.location.href="/data/queryedit_manage.html?id="+id;
    } else {
        $.ajax({
            url: "/data/delet_manage.html",
            type: "post",
            dataType: "json",
            data: {id: id},
            success: function (data) {
                if (data == "success") {
                    document.getElementById('box').deleteRow(index);
                    for(var i=1;i<=all;i++){
                        $(".pagination ul li").eq(1).remove();
                    }
                    init();
                } else {
                    alert("删除失败,你的商品在订单中");
                }

            }
        })
    }


})