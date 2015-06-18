<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: markoka
  Date: 18.06.2015
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lisa Service Order</title>
</head>
<body>
<form:form method="POST">
  <form:label path="">Klient: </form:label>

  <form:label path="price">Tööde maksumus:</form:label>
  <form:input path="price"></form:input>

  <br>

  <form:label path="note">Kommentaar</form:label>
  <form:textarea path="note"></form:textarea>

  <form:input path="employeeUsername" type="hidden" value='${param.username}'></form:input>
  <form:input path="createdBy" type="hidden" value='${param.username}'></form:input>
  <form:input path="serviceId" type="hidden" value='${param.id}'></form:input>

  <br>
  <input type="submit" value="Sisesta"/>
</form:form>
</body>
</html>
