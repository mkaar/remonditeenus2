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
<h2>Märkmed:</h2><br>
<table border="1">
  <tr>
    <td>Service request ID: </td>
    <td>Created on: </td>
    <td>Status: </td>
  </tr>
  <tr>
    <td><c:out value="${serviceRequest.getServiceRequest()}"/></td>
    <td><c:out value="${serviceRequest.getCreated()}"/></td>
    <td><c:out value="${serviceRequest.getServiceRequestStatusType().getName()}"/></td>
  </tr>
</table>
<table border="1">
  <tr>
    <td>Kommentaator:</td>
    <td>Märge:</td>
  </tr>
<c:forEach items="${serviceNotes}" var="sn">
  <tr>
  <td>
    <c:if test="${not empty sn.getCustomer()}">
      <c:out value="${sn.getCustomer().getUserAccount().getUsername()}"/>
    </c:if>
    <c:if test="${not empty sn.getEmployee()}">
      <c:out value="${sn.getEmployee().getPerson().getFirstName()}"/>
    </c:if>
  </td>
  <td>
    <c:out value="${sn.getNote()}"/>
  </td>
  </tr>
</c:forEach>
</table>
</body>
</html>
