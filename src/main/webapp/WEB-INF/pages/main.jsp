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
  <title>Електронные карточки пациентов</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Карточки пациентов</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>На главную</b></a><br>
    <a href=""><b>Доктора</b></a><br>
    <a href=""><b>Страховщики</b></a><br>
  </p>
</div>

<div style="float: left; width: 59%">
  <form action="/main">
    <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
      <tr>
        <th width="50%">Ф.И.О.</th>
        <th width="25%">Адресс</th>
        <th width="25%">Страховщик</th>
      </tr>
      <c:forEach var="patient" items="${patientList}">
        <tr>
          <td><a href="/patient?patientId=${patient.patientId}">${patient.fio}</a></td>
          <td>${patient.address}</td>
          <td>${patient.insurerName}</td>
        </tr>
      </c:forEach>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
