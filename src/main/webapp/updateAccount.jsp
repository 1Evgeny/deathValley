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
    <title>UpdateAccount</title>
</head>
<body>
<h2>UPDATE ACCOUNT</h2>
<form action='<%=request.getContextPath()%>/update' method='post' accept-charset='UTF-8'>
    <input type='hidden' name='id' value='<%=request.getParameter("id")%>'></br>
    Account: <input type = 'text' name = 'account'></br>
    User ID: <input type = 'text' name = 'userId'></br>
    <input type='submit' value='Update user'></br>
</form>
<form action='<%=request.getContextPath()%>/show' method='get' accept-charset='UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>