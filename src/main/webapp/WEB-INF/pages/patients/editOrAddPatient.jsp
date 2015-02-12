<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <title>Пациент</title>

  <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>
  <link href="${bootstrapCss}" rel="stylesheet"/>
  
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные о пациенте</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
  <form:form modelAttribute="patient" method="post">
    <input type="hidden" value="${patient.patientId}" name="patientId">
    <table class="table table-striped">
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
            <option value="0">...</option>
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
        <td colspan="2">
          <input type="submit" value="OK" name="ok">
        </td>
      </tr>
    </table>
  </form:form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
