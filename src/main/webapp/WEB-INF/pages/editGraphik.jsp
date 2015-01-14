<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 10.01.2015
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Запись на прием</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Запись на прием</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
    <a href="/addGraphik"><b>Записатся на прием</b></a>
  </p>
</div>

<div style="float: left; width: 59%">
  <form action="/addGraphik" method="post">
    <table align="center">
      <tr>
        <td>Пациент:</td>
        <td>
          <select name="patientId">
            <c:forEach var="patient" items="${patients}">
              <option value="${patient.patientId}">${patient.fio}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      
      <tr>
        <td>Доктор:</td>
        <td>
          <select name="doctorId">
            <c:forEach var="doctor" items="${doctors}">
              <option value="${doctor.doctorId}">${doctor.fio}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      
      <tr>
        <td>Дата:</td>
        <td></td>
        </tr>
      
      <tr>
        <td>
          День: 
          <select name="day">
            <c:forEach var="day" items="${days}">
              <option value="${day}">${day}</option>
            </c:forEach>
          </select>
          </td>
        <td>
          Месяц:
          <select name="month">
            <c:forEach var="month" items="${months}">
              <option value="${month}">${month + 1}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      
      <tr>
        <td>
          <input type="submit" value="OK" name="ok">
        </td>
      </tr>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>