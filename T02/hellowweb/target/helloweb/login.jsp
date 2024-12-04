<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 5/11/24
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="login">
        <label for="name"></label>
        <input type="text" id="name" name="name" required>

        <label for="password"></label>
        <input type="password" id="password" name="password" required>

        <button type="submit" value="Login">Login</button>
    </form>

    <a href="createUser">Go to Create Account</a>
</body>
</html>
