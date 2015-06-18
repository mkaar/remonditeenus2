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
<c:if test="${param.muudetud}">
  <h1>Staatus Muudetud!</h1>
</c:if>
<h2>Kõik service requestid:</h2><br>
<table border="1">
  <tr>
    <td>Service request ID: </td>
    <td>Klient: </td>
    <td>Created on: </td>
    <td>Töötaja: </td>
    <td>Status: </td>
    <td></td>
    <td></td>
  </tr>
<c:forEach items="${ServiceList}" var="sr">
  <tr>
    <td><c:out value="${sr.getServiceRequest()}"/></td>
    <td><c:out value="${sr.customer.subject.person} ${sr.customer.subject.firstName} ${sr.customer.subject.lastName}" /></td>
    <td><c:out value="${sr.getCreated()}"/></td>
    <td><c:out value="${sr.createdBy.person.person} ${sr.createdBy.person.firstName} ${sr.createdBy.person.lastName}"/></td>
    <td><c:out value="${sr.getServiceRequestStatusType().getName()}"/></td>
    <td><a href="/remonditeenus/notes?id=<c:out value="${sr.getServiceRequest()}"/>">Vaata märkuseid</a></td>
    <td><a href="edit?id=<c:out value="${sr.getServiceRequest()}"/>">Redigeeri</a></td>
  </tr>
</c:forEach>
</table>

<br>
<a href="/tootaja/">Uus pöördumine</a>

</body>
</html>
