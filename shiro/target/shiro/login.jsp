<%--
  Created by IntelliJ IDEA.
  User: xueba
  Date: 2019/2/1
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
   <form action="/login" method="post">
       账号：<input type="text" name="username">
       密码：<input type="text" name="password">
       <button type="submit">登录</button>
   </form>
</body>
</html>
