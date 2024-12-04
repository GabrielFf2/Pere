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
    <form method="post" action="create">
        <label for="title">Title</label>
        <input type="text" id="title" name="title"required>

        <label for="description">Description</label>
        <input type="text" id="description" name="description" required>

        <label for="year">Year</label>
        <input type="text" id="year" name="year" required>


        <button type="submit" value="create">Create Peli</button>
    </form>
<br>
<a href="movies">Pelicules</a>
</body>
</html>
