<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.nasaweb.model.Asteroid" %> <!-- Ajusta el paquete -->
<%
    List<Asteroid> asteroids = (List<Asteroid>) session.getAttribute("asteroids");

%>
<!DOCTYPE html>
<html>
<head>
    <title>Asteroides</title>
</head>
<body>
<h1>Lista de Asteroides</h1>
<a href="saveAsteroids">Agafar Asteroides De la nasa</a>
<a href="createAsteroid">Crear Asteroide</a>
<a href="LoginUser">Log OUT</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Magnitud</th>
        <th>Diámetro</th>
        <th>¿Es peligroso?</th>
        <th>Avistaments</th>
        <th>Eliminar</th>
        <th>Edita</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="asteroid" items="${sessionScope.asteroids}">
        <tr>
            <td>${asteroid.id}</td>
            <td>${asteroid.name}</td>
            <td>${asteroid.magnitude}</td>
            <td>${asteroid.diameter}</td>
            <td>${asteroid.dangerous ? 'Sí' : 'No'}</td>
            <td><a href="aproaches?id=${asteroid.id}"> Veure</a></td>
            <td><a href="eliminar?id=${asteroid.id}"> Eliminar</a></td>
            <td><a href="updateAsteroid?id=${asteroid.id}"> Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>