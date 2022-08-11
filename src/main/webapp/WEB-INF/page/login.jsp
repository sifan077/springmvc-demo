<%--
  Created by IntelliJ IDEA.
  User: 思凡
  Date: 2022/7/6
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/app/login">
    <label>
        username:
        <input type="text" name="name">
    </label> <br>
    <label>
        password:
        <input type="password" name="password">
    </label> <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
