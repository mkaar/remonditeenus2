<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: markoka
  Date: 9.06.2015
  Time: 6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Lisa märge</h1>
<form:form action="newNotes" method="post" commandName="userForm">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2>Uus Märge</h2></td>
    </tr>
    <tr>
      <td>Märge:</td>
      <td><form:input path="note" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="Sisesta" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
