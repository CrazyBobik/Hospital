<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>Страховщики</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Страховщики</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">

  <p align="right">
    <spring:url value="/insurers/new.html" var="newInsurer"/>
    <a href="${fn:escapeXml(newInsurer)}">Добавить страховщика</a>
  </p>

  <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
    <tr>
      <th width="50%">Имя</th>
      <th width="50%">Контакты</th>
    </tr>
    <c:forEach var="insurer" items="${insurerList}">
      <tr>
        <td>
          <table cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
            <tr>
              <td rowspan="2" width="50%"><c:out value="${insurer.name}"/></td>
              <td width="50%">
                <spring:url value="/insurers/{insurerId}/edit.html" var="editInsurer">
                  <spring:param name="insurerId" value="${insurer.insurerId}"/>
                </spring:url>
                <a href="${fn:escapeXml(editInsurer)}">Редактировать</a>
              </td>
            </tr>
            <tr>
              <td>
                <spring:url value="/insurers/{insurerId}/delete.html" var="deleteInsurer">
                  <spring:param name="insurerId" value="${insurer.insurerId}"/>
                </spring:url>
                <a href="${fn:escapeXml(deleteInsurer)}">Удалить</a>
              </td>
            </tr>
          </table>
        </td>
        <td>${insurer.contacts}</td>
      </tr>
    </c:forEach>
  </table>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
