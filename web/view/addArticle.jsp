<%--
  Created by IntelliJ IDEA.
  User: car
  Date: 2016/12/1
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新文章</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
</head>
<body>

<form action="${article.id == null ? 'addArticle' : 'modifyArt'}" method="post">
    <input type="hidden" name="id" value="${article.id}" />
    <label for="title">文章标题</label>
    <input type="text" id="title" name="title" placeholder="标题" style="width:700px;" value="${article.title}"/>
    <br />
    <br />
    <label for="content">文章内容</label>
    <textarea rows="10" cols="100" id="content" name="content" placeholder="文章内容">${article.content}</textarea>
    <button type="submit" onclick="checkArt()">发布文章</button>
</form>

<script>
    function checkArt() {
        var title = document.getElementById("title").value;
        title = title.replace(/\s+/g,"");

        if (document.getElementById("title").value == '') {
            alert("标题不能为空");
            return false;
        }
    }
</script>
</body>
</html>
