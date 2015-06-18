<%--
  Created by IntelliJ IDEA.
  User: markoka
  Date: 18.06.2015
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<h1>results:</h1>
<c:forEach items="${ServiceList}" var="sr">
  <tr>
    <td><c:out value="${sr.getServiceRequest()}"/></td>
    <td><c:out value="${sr.getCreated()}"/></td>
    <td><c:out value="${sr.getServiceRequestStatusType().getName()}"/></td>
    <td><a href="notes?id=<c:out value="${sr.getServiceRequest()}"/>">Vaata märkuseid</a></td>
  </tr>
</c:forEach>
</body>
</html>
