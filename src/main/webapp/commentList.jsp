<%--
  Created by IntelliJ IDEA.
  User: renr
  Date: 2019/6/6
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">


    </style>
    <script type="text/javascript" src="css/bootstrap.min.css"></script>
    <script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
</head>
<body>
<div style="text-align: center">
    <h1>评论列表</h1><input type="button" onclick="javascript:window.location.href ='list.html';" value="返回新闻列表"/>
<br />
<table width="800" border="1px" class="table table-bordered" style="text-align: center;margin: auto">
    <thead>
        <tr>
            <th>评论编号</th>
            <th>评论内容</th>
            <th>评论人</th>
            <th>评论时间</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><a href="#">aaaa</a></td>
            <td>java</td>
            <td>2010</td>
        </tr>

        <tr>

            <td colspan="4"><a href="javascript:searchInfo(1)">首页</a>|
                <a href="javascript:searchInfo(2)">上一页</a>|
                <a href="javascript:searchInfo(2)">下一页</a>|
                <a href="javascript:searchInfo(10)">末页</a>
                第1页/共10页
                （10条记录）</td>
        </tr>
    </tbody>

</table>
</div>

<script type="text/javascript">
    $(function(){
        searchInfo(1);
    })

</script>

<script type="text/javascript">
    function searchInfo(page){
        $.ajax({
            type:"get",
            url:"comment/list.do",
            data:{nid:${param.id},page:page,limit:5},
            dataType:"json",
            success:function(data){
                if(data.code == 1){
                    $("tbody").empty();
                    var infos = data.info.list;
                    for(var i = 0; i < infos.length; i++){
                        var html = '<tr>\n' +
                            '            <td>' + infos[i].id + '</td>\n' +
                            '            <td>' + infos[i].comment + '</a></td>\n' +
                            '            <td>' + infos[i].commentator + '</td>\n' +
                            '            <td>' + infos[i].commentTime + '</td>\n' +
                            '        </tr>';
                        $("tbody").append($(html));
                    }
                    var html = '<tr><td colspan="4"><a href="javascript:searchInfo(1)">首页</a>|\n' +
                        '                <a href="javascript:searchInfo(' + (data.info.currentPage - 1) + ')">上一页</a>|\n' +
                        '                <a href="javascript:searchInfo(' + (data.info.currentPage + 1) + ')">下一页</a>|\n' +
                        '                <a href="javascript:searchInfo(' + data.info.totalPage + ')">末页</a>\n' +
                        '                第' + data.info.currentPage + '页/共' + data.info.totalPage + '页\n' +
                        '                （' + data.info.count + '条记录）</td></tr>';
                    $("tbody").append($(html));
                }
            }


        })
    }

</script>


</body>
</html>