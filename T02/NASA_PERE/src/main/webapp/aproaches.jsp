<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.nasaweb.model.Asteroid" %>
<%@ page import="com.project.nasaweb.model.Aproach" %>
<!-- Ajusta el paquete -->
<%
    List<Aproach> aproaches = (List<Aproach>) session.getAttribute("apraches");
%>
<!DOCTYPE html>
<html>
<head>
    <title>aproaches</title>
</head>
<body>
<h1>Lista de aproaches</h1>
<a href="createAproach?idAsteroid=${idAsteroid}">Crear Avistamiento</a>

<h1><% session.getAttribute("Error"); %></h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>data</th>
        <th>velocity</th>
        <th>distance</th>
        <th>¿Es orbiting_body?</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="aproaches" items="${sessionScope.aproaches}">
        <tr>
            <td>${aproaches.id}</td>
            <td>${aproaches.data}</td>
            <td>${aproaches.velocity}</td>
            <td>${aproaches.distance}</td>
            <td>${aproaches.orbiting_body}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

