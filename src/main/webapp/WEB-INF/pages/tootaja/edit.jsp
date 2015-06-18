<%--suppress XmlDuplicatedId --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: markoka
  Date: 18.06.2015
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="POST" action="edit/changeCustomer">
  Praegune klient: ${serviceRequest.customer.subject.firstName} ${serviceRequest.customer.subject.lastName}<br>
  <label for="customer">Muuda klienti: </label>
  <select id="customer" name="customer">
    <c:forEach var="item" items="${customers}">
      <option value="${item.subject.person}">${item.subject.firstName} ${item.subject.lastName}</option>
    </c:forEach>
  </select><br>
  <input type="hidden" id="id" name="id" value="${param.id}" />
  <input type="submit" value="Sisesta"/>
</form>

<form method="POST" action="edit/changeStatus">
  Praegune staatus: ${serviceRequest.getServiceRequestStatusType().getName()}<br>
  <label for="status">Muuda staatust: </label>
  <select id="status" name="status">
    <c:forEach var="type" items="${serviceTypes}">
      <option value="${type.id}">${type.name}</option>
    </c:forEach>
  </select><br>
  <input type="hidden" id="id" name="id" value="${param.id}" />
  <input type="submit" value="Sisesta"/>
</form>

<h1><a href="serviceOrder?id=${param.id}">Vormista tellimus</a></h1>
</body>
</html>
