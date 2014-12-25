<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 25.12.2014
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Електронные карточки пациентов</title>
</head>
<body>
<form action="/main">
  <table border="1">
    <c:forEach var="patient" items="${patientList}">
      <tr>
        <td>${patient.patientId}</td>
        <td>${patient.fio}</td>
        <td>${patient.address}</td>
        <td>${patient.contacts}</td>
        <td>${patient.insurerId}</td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
