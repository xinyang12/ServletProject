<%--
  Created by IntelliJ IDEA.
  User: car
  Date: 2016/11/30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="/ServletProject/login" method="post">
      <label for="username">用户名</label>
      <input type="text" id="username" name="username" placeholder="username" />
      <label for="password">密码</label>
      <input type="password" id="password" name="password" placeholder="password" />

      <button type="submit" onclick="">登录</button>
      <button type="button" onclick="window.location.href='view/register.jsp'">注册</button>
  </form>

  <script>

  </script>
  </body>
</html>
