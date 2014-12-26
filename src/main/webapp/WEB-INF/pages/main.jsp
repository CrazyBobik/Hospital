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
<body bgcolor="#ffe4c4">
<form action="/main">
  <font color="#dc143c"><h1 align="center">Карточки пациентов</h1></font>
  <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="4" width="70%" align="center">
    <tr>
      <th width="50%">Ф.И.О.</th>
      <th width="25%">Адресс</th>
      <th width="25%">Страховщик</th>
    </tr>
    <c:forEach var="patient" items="${patientList}">
      <tr>
          <%--<td>${patient.patientId}</td>--%>
        <td><a href="welcome.jsp">${patient.fio}</a></td>
            <td>${patient.address}</td>
            <td>${patient.insurerName}</td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
