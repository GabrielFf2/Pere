<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="createAproach">
        <label for="id">ID</label>
        <input type="number" id="id" name="id"required>

        <label for="date">date</label>
        <input type="date" id="date" name="date" required>

        <label for="velocity">velocity</label>
        <input type="number" id="velocity" name="velocity" required>

        <label for="distance">distance</label>
        <input type="number" id="distance" name="distance" required>

        <label for="orbiting_body">orbiting_body</label>
        <input type="text" id="orbiting_body" name="orbiting_body">

        <input type="hidden" id="idAsteroid" value="${idAsteroid}">


        <button type="submit" value="createAproach">Crear Avistament</button>
    </form>
<br>
<a href="asteroids"> Llista d'asteroides</a>
</body>
</html>
