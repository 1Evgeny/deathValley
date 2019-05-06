<%--
  Created by vorokhobko2011@yandex.ru.
  User: Evgeny Vorokhobko
  Date: 06.05.2019.
  Time: 1:53.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateUsers</title>
</head>
<body>
<h2>CREATE USER</h2>
<form action='<%=request.getContextPath()%>/createUser' method='post' accept-charset = 'UTF-8'>
    Name User: <input type = 'text' name = 'name'></br>
    Super User: <input type = 'text' name = 'superName'></br>
    <input type = 'submit' name = 'Create User'></br>
</form>
<form action='<%=request.getContextPath()%>/show' method='get' accept-charset = 'UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>