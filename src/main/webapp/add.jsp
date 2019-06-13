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
    <title>增加评论</title>
    <script type="text/javascript" src="css/bootstrap.min.css"></script>
    <script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
</head>
<body>
<div style="text-align: center">
<form onsubmit="return false;">

    <h1>增加评论</h1>
    评论内容<textarea name="comment"></textarea><br />
    评论人<input type="text" name="commentator" /><br />

    <input type="submit" value="提交" />
    <input type="button" onclick="javascript:window.location.href ='list.html';" value="返回"/>
</form>
</div>

<script type="text/javascript">



    $("form").submit(function(){
        $.ajax({
            type:"post",
            url:"comment/add.do?nid=${param.id}",
            data:$("form").serialize(),
            dataType:"json",
            success:function(data){
                if(data.code == 1){
                    alert("添加成功!");
                    window.location.href = "list.html";
                }
            }
        })
    })

</script>



</body>
</html>