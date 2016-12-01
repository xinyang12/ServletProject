<%--
  Created by IntelliJ IDEA.
  User: car
  Date: 2016/12/1
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
</head>
<body>
<form action="/ServletProject/register" method="post">
    <label for="username">用户名</label>
    <input type="text" id="username" name="username" placeholder="username" />
    <label for="password">密码</label>
    <input type="password" id="password" name="password" placeholder="password" />
    <label for="rePassword">确认密码</label>
    <input type="password" id="rePassword" name="rePassword" placeholder="rePassword" />

    <button type="submit" onclick="return myCheck();">注册</button>
</form>

<script>
    function myCheck() {
        var password   = document.getElementById("password").value;
        var rePassword = document.getElementById("rePassword").value;

        if (password != rePassword) {
            alert("两次输入的密码必须相等");
            return false;
        }
    }
</script>
</body>
</html>
