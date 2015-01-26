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
    <title>Доктора</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Доктора</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
 
    <p align="right">
      <spring:url value="/doctors/new.html" var="newDoctor"/>
      <a href="${fn:escapeXml(newDoctor)}">Добавить доктора</a>
    </p>
  
    <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
      <tr>
        <th width="50%">Ф.И.О.</th>
        <th width="50%">Пост</th>
      </tr>
      <c:forEach var="doctor" items="${doctorList}">
        <tr>
          <td>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
              <tr>
                <td rowspan="3" width="50%"><c:out value="${doctor.fio}"/></td>
                <td width="50%">
                  <spring:url value="/doctors/{doctorId}/graphiks.html" var="graphikForDoctor">
                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(graphikForDoctor)}">График приемов</a>
                </td>
              </tr>
              <tr>
                <td>
                  <spring:url value="/doctors/{doctorId}/edit.html" var="editDoctor">
                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(editDoctor)}">Редактировать</a>
                </td>
              </tr>
              <tr>
                <td>
                  <spring:url value="/doctors/{doctorId}/delete.html" var="deleteDoctor">
                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(deleteDoctor)}">Удалить</a>
                </td>
              </tr>
            </table>
          </td>
          <td>${doctor.post}</td>
        </tr>
      </c:forEach>
    </table>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
