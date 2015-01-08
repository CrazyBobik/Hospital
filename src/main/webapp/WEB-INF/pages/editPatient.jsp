<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пациент</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные о пациенте</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
    <a href="/addgraphik"><b>Записатся на прием</b></a>
  </p>
</div>

<div style="float:left; width: 59%">
  <form action="/editPatient" method="post">
    <input type="hidden" value="${patient.patientId}" name="patientId">
    <table>
      <tr>
        <td>Ф.И.О.:</td>
        <td>
          <input type="text" value="${patient.fio}" name="fio">
        </td>
      </tr>
      <tr>
        <td>Адресс:</td>
        <td>
          <textarea cols="70" rows="3" name="address">${patient.address}</textarea>
        </td>
      </tr>
      <tr>
        <td>Контакты:</td>
        <td>
          <textarea cols="70" rows="5" name="contacts">${patient.contacts}</textarea>
        </td>
      </tr>
      <tr>
        <td>Страховщик:</td>
        <td>
          <select name="insurerId">
            <option value="not">...</option>
            <c:forEach var="insurer" items="${insurers}">
              <c:choose>
                <c:when test="${insurer.insurerId==patient.insurerId}">
                  <option value="${insurer.insurerId}" selected>${insurer.name}</option>
                </c:when>
                <c:otherwise>
                  <option value="${insurer.insurerId}">${insurer.name}</option>
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
