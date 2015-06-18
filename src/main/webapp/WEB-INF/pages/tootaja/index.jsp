<%--suppress XmlDuplicatedId --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Töötaja</title>
</head>
<body>
<h1><a href="/tootaja/all">Kõik pöördumised</a></h1>
<c:if test="${param.lisatud}">
<h1>Lisatud!</h1>
</c:if>
<h1>Uus kliendi pöördumine</h1>
<form:form method="POST">
    <form:label path="person">Klient: </form:label>
    <form:select path="person">
      <c:forEach var="item" items="${customers}">
        <option value="${item.subject.person}">${item.subject.firstName} ${item.subject.lastName}</option>
      </c:forEach>
    </form:select><br>
    <form:label path="serviceDescByCustomer">Kliendi kommentaar:</form:label>
    <form:textarea path="serviceDescByCustomer"></form:textarea>

    <br>

    <form:label path="serviceDescByEmployee">Töötaja kommentaar</form:label>
    <form:textarea path="serviceDescByEmployee"></form:textarea>

    <form:input path="employeeUsername" type="hidden" value='${param.username}'></form:input>
    <br>
    <input type="submit" value="Sisesta"/>
</form:form>


<h1>Otsi teenuseid</h1>

<form action="search" method="POST">
    <label for="client">Otsi kliendi järgi</label>
    <input type="text" id="client" name="client" />
    <input type="submit" value="Otsi" />
</form>

<form action="search" method="POST">
    <label for="orderId">Otsi Service request-i id järgi</label>
    <input type="text" id="orderId" name="orderId" />
    <input type="submit" value="Otsi" />
</form>

<form action="search" method="POST">
    <label for="employee">Otsi Service request-i id järgi</label>
    <input type="text" id="employee" name="employee" />
    <input type="submit" value="Otsi" />
</form>

<form action="search" method="POST">
    <label for="status">Otsi statuse nime järgi</label>
    <input type="text" id="status" name="status" />
    <input type="submit" value="Otsi" />
</form>

</body>
</html>
