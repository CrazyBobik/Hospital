<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 28.12.2014
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Диагноз</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные диагноза</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
  <form:form modelAttribute="diagnosis" method="post">
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
          <input type="hidden" value="${patient.patientId}" name="patientId">
          <c:out value="${patient.fio}"/>
        </td>
      </tr>
      <tr>
        <td>Доктор:</td>
        <td>
          <select name="doctorId">
            <option value="0">...</option>
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
  </form:form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
