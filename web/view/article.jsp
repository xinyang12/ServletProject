<%--
  Created by IntelliJ IDEA.
  User: car
  Date: 2016/12/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title}</title>
</head>
<body>
<div>
    <h2 style="text-align: center">${article.title}</h2>
    <br />
    <br />
    <p>${article.content}</p>
</div>

<br />
<br />
<hr />
<br />
<div>
    <form action="addComment" method="post">
        <input type="hidden" name="articleId" value="${article.id}" />
        <label for="commentTitle">标题</label>
        <input id="commentTitle" name="commentTitle" placeholder="评论标题" style="width:700px;"/>
        <br />
        <br />
        <label for="commentContent">内容</label>
        <textarea rows="10" cols="100" id="commentContent" name="commentContent" placeholder="评论内容"></textarea>
        <button type="submit" onclick="checkArt()">提交评论</button>
    </form>
</div>
</body>

<script>
    function checkArt() {
        var title = document.getElementById("commentTitle").value;
        title = title.replace(/\s+/g,"");

        if (document.getElementById("commentTitle").value == '') {
            alert("评论标题不能为空");
            return false;
        }
    }
</script>
</html>
