<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 28.12.2014
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Диагноз</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные диагноза</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
  </p>
</div>

<div style="float:left; width: 59%">
  <form action="/editDiagnosis" method="post">
    <input type="hidden" value="${diagnosis.diagnosisId}" name="diagnosisId">
    <table>
      <tr>
        <td>Название:</td>
        <td>
          <input type="text" value="${diagnosis.name}" name="name">
        </td>
      </tr>
      <tr>
        <td>Описание:</td>
        <td>
          <textarea cols="70" rows="12" name="text">${diagnosis.text}</textarea>
        </td>
      </tr>
      <tr>
        <td>Пациент:</td>
        <td>
          <select name="patientId">
            <c:forEach var="patient" items="${patients}">
              <c:choose>
                <c:when test="${patient.patientId==diagnosis.patientId}">
                  <option value="${patient.patientId}" selected>${patient.fio}</option>
                </c:when>
                <c:otherwise>
                  <option value="${patient.patientId}">${patient.fio}</option>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td>Доктор:</td>
        <td>
          <select name="doctorId">
            <option value="not">...</option>
            <c:forEach var="doctor" items="${doctors}">
              <c:choose>
                <c:when test="${doctor.doctorId==diagnosis.doctorId}">
                  <option value="${doctor.doctorId}" selected>${doctor.fio}</option>
                </c:when>
                <c:otherwise>
                  <option value="${doctor.doctorId}">${doctor.fio}</option>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="OK" name="ok">
        </td>
        <td>
          <input type="submit" value="Отмена" name="cancel">
        </td>
      </tr>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
