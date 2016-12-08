<%--
  Created by IntelliJ IDEA.
  User: car
  Date: 2016/12/1
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<button type="button" onclick="location.href='view/addArticle.jsp'">添加新文章</button>
<br />
<br />

<c:if test="${fn:length(list) == 0}">
    内容为空
</c:if>

<c:forEach items="${list}" var="tmp">
    <div style="border: 1px solid black">
        <h2>${tmp.id}</h2>
        <br />
        <h2>${tmp.title}</h2>
        <br />
        <p>${tmp.content}</p>
        <br />
        <button type="button" onclick="deleteArticle(${tmp.id})">删除该篇文章</button>
    </div>
    <br />
</c:forEach>

<script>
    function deleteArticle(id) {
        if(confirm("你确定要删除这篇文章吗？")) {
            location.href='/ServletProject/deleteArticle?id=' + id
        }
    }
</script>
</body>
</html>
