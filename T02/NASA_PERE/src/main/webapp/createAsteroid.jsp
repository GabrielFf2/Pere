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
    <form method="post" action="createAsteroid">
        <label for="id">ID</label>
        <input type="number" id="id" name="id"required>

        <label for="name">Nom</label>
        <input type="text" id="name" name="name" required>

        <label for="Magnitud">Magnitud</label>
        <input type="number" id="Magnitud" name="Magnitud" required>

        <label for="Diametro">Diámetro</label>
        <input type="number" id="Diametro" name="Diametro" required>

        <label for="danger">Es perillos</label>
        <input type="checkbox" id="danger" name="danger">


        <button type="submit" value="createAsteroid">Crear Asteroid</button>
    </form>
<br>
<a href="asteroids"> Llista d'asteroides</a>
</body>
</html>
