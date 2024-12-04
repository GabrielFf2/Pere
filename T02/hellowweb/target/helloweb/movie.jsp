<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<html>
<head>
    <title>Movies</title>
</head>
<body>
<h1>${peli.title}</h1>
    <p>
        Title: ${peli.title}<br>
        Description: ${peli.description}<br>
        Any: ${peli.year}<br>
    </p>
<a href="movies"> Go Back</a>
</body>
</html>
