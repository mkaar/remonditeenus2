<%--
  Created by IntelliJ IDEA.
  User: markoka
  Date: 9.06.2015
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Kasutaja ${username} service requestid:</h2><br>
<table border="1">
  <tr>
    <td>Service request ID: </td>
    <td>Created on: </td>
    <td>Status: </td>
    <td></td>
  </tr>
<c:forEach items="${ServiceList}" var="sr">
  <tr>
    <td><c:out value="${sr.getServiceRequest()}"/></td>
    <td><c:out value="${sr.getCreated()}"/></td>
    <td><c:out value="${sr.getServiceRequestStatusType().getName()}"/></td>
    <td><a href="notes?id=<c:out value="${sr.getServiceRequest()}"/>">Vaata märkuseid</a></td>
  </tr>
</c:forEach>
</table>

<br>
<a href="newRequest">Uus pöördumine</a>

</body>
</html>
