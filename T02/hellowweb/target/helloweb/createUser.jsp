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
</head>
<body>
    <form method="post" action="createUser">
        <label for="name"></label>
        <input type="text" id="name" name="name" required>

        <label for="password"></label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Create</button>
    </form>
</body>
</html>
