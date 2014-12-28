<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 26.12.2014
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Информация о пациенте</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">${patient.fio}</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>На главную</b></a><br>
    <a href=""><b>Доктора</b></a><br>
    <a href=""><b>Страховщики</b></a><br>
  </p>
</div>

<div style="float:left; width: 59%">
  <table cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
    <tr>
      <td>
        <dl>
          <dt><b>Адресс:</b></dt>
          <dd>${patient.address}</dd>
          <dt><b>Контакты:</b></dt>
          <dd>${patient.contacts}</dd>
          <dt><b>Страховщик:</b></dt>
          <dd>${patient.insurerName}</dd>
        </dl>
      </td>
    </tr>
  </table>
  
  <form action="/patient">
    <p align="right">
      <input type="hidden" value="${patient.patientId}" name="patientId">
      <input type="submit" value="Delete" name="del">
      <input type="submit" value="Edit" name="edit">
      <input type="submit" value="Add" name="add">
    </p>
    <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
      <tr>
        <th width="30%">Диагноз</th>
        <th width="50%">Описание диагноза</th>
        <th width="20%">Доктор</th>
      </tr>
      <c:forEach var="diagnosis" items="${patient.diagnosisViewList}">
        <tr>
          <td>
            <input type="radio" value="${diagnosis.diagnosisId}" name="diagnosisId">
              ${diagnosis.name}
          </td>
          <td>${diagnosis.text}</td>
          <td>
            <dl>
              <dt>${diagnosis.doctorPost}</dt>
              <dd>${diagnosis.doctorName}</dd>
            </dl>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
