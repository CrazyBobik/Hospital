<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 25.12.2014
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>Електронные карточки пациентов</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Карточки пациентов</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
  
    <p align="right">
      <spring:url value="patients/new.html" var="addURL"/>
      <a href="${fn:escapeXml(addURL)}">Добавить пациента</a>
    </p>
  
    <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
      <tr>
        <th width="50%">Ф.И.О.</th>
        <th width="25%">Адресс</th>
        <th width="25%">Страховщик</th>
      </tr>
      <c:forEach var="patient" items="${patientList}">
        <tr>
          <td>
            <spring:url value="patients/{patientId}.html" var="patientURL">
              <spring:param name="patientId" value="${patient.patientId}"/>
            </spring:url>
            <a href="${fn:escapeXml(patientURL)}"><c:out value="${patient.fio}"/></a>
          </td>
          <td>${patient.address}</td>
          <td>${patient.insurerName}</td>
        </tr>
      </c:forEach>
    </table>

</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
