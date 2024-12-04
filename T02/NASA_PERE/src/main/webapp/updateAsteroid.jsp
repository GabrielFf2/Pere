<jsp:useBean id="asteroid" scope="request" type="com.sun.org.apache.xml.internal.security.signature.SignatureProperty"/>
<%@ page import="com.project.nasaweb.model.Asteroid" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="createAsteroid">
    <c var="asteroid" items="${sessionScope.asteroid}">
        <label for="id">ID</label>
        <input type="number" id="id" name="id" value="${asteroid.id}" required>

        <label for="name">Nom</label>
        <input type="text" id="name" name="name" value="${asteroid.name}" required>

        <label for="Magnitud">Magnitud</label>
        <input type="number" id="Magnitud" name="Magnitud" value="${asteroid.magnitude}" required>

        <label for="Diametro">Diámetro</label>
        <input type="number" id="Diametro" name="Diametro" value="${asteroid.diameter}" required>

        <label for="danger">Es perillós</label>
        <input type="checkbox" id="danger" name="danger" ${asteroid.isDangerous ? 'checked' : ''}>

        <button type="submit" value="updateAsteroid">Update Asteroid</button>
    </c>
</form>
<br>
<a href="asteroids">Llista d'asteroides</a>
</body>

</html>
