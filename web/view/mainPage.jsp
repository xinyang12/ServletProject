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
<button onclick="window.location.href='view/addArticle.jsp'">添加新文章</button>

<c:if test="${fn:length(list) == 0}">
    内容为空
</c:if>
<c:if test="${fn:length(list) != 0}">
    内容不为空
</c:if>

<c:forEach items="${list}" var="tmp">
    <h2>${tmp.title}</h2>
    <br />
    <p>${tmp.content}</p>
    <br />
</c:forEach>

<script>
</script>
</body>
</html>
