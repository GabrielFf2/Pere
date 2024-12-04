<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<html>
<head>
    <title>Movies</title>
</head>
<body>
<h1>Llista de pelis:</h1>

<a href="create"> CREATE NEW PELI</a>


<c:forEach var="peli" items="${pelis}">
    <p>
        <a>Title: ${peli.title}</a>
        <a href="movieById?id=${peli.id}"> VIEW</a>
        <a href="update?id=${peli.id}"> UPDATE</a>
        <a href="delete?id=${peli.id}"> DELETE</a>
    </p>
</c:forEach>
</body>
</html>
