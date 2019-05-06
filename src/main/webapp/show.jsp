<%@ page import="by.vorokhobko.model.User" %>
<%@ page import="by.vorokhobko.model.Account" %>
<%@ page import="by.vorokhobko.database.DatabaseDAO" %>
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
    <title>Show</title>
</head>
<body>
<h2>ALL USERS</h2>
<form method='post'>
    <table border = "2">

        <% DatabaseDAO daoUser = new DatabaseDAO();
        for (User user : daoUser.findAllUsers()) {%>
            <tr>
                <th>CHOICE</th>
                <th>ID</th>
                <th>NAME</th>
                <th>SUPER NAME</th>
            </tr>
            <tr>
                <td><input type='radio' name='id' value= <%=user.getUserId()%>></td>
                <td><%=user.getUserId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getSuperName()%></td>
            </tr>
        <hd/>
        <%}%>
        <% DatabaseDAO daoAccount = new DatabaseDAO();
            for (Account account : daoAccount.findAllAccounts()) {%>
        <tr>
            <th>CHOICE</th>
            <th>ID</th>
            <th>ACCOUNT</th>
            <th>USER ID</th>
        </tr>
        <tr>
            <td><input type='radio' name='id' value= <%=account.getAccountId()%>></td>
            <td><%=account.getAccountId()%></td>
            <td><%=account.getAccount()%></td>
            <td><%=account.getUserId()%></td>
        </tr>
        <%}%>

    </table><br>
    <input type='submit' value='Add user' formaction='<%=request.getContextPath()%>/createUser'>
    <input type='submit' value='Add account' formaction='<%=request.getContextPath()%>/createAccount'>
    <input type='submit' value='Update user' formaction='<%=request.getContextPath()%>/updateUser'>
    <input type='submit' value='Update account' formaction='<%=request.getContextPath()%>/updateAccount'>
    <input type='submit' value='Delete' formaction='<%=request.getContextPath()%>/delete'>
</form>
</body>
</html>