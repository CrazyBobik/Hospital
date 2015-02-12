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

    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Карточки пациентов</h1></font>
  
    <table class="table table-striped">
        <tr>
            <th width="50%">Ф.И.О.</th>
            <th width="25%">Адресс</th>
            <th width="25%">Страховщик</th>
        </tr>
        <c:forEach var="patient" items="${patientList}">
            <tr>
                <td>
                    <spring:url value="/patients/{patientId}.html" var="patientURL">
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

<div style="float: left; width: 20%">
    <div class="list-group">
        <spring:url value="patients/new.html" var="addURL"/>
        <a href="${fn:escapeXml(addURL)}" class="list-group-item list-group-item-info">
            <span class="glyphicon glyphicon-plus"/>
            Добавить пациента
        </a>
    </div>
</div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>
