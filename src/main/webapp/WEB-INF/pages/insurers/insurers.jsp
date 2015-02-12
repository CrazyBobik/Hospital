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
    
    <jsp:include page="../parts/css.jsp"/>

</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Страховщики</h1></font>
  
    <table class="table table-striped">
        <tr>
            <th width="65%">Имя</th>
            <th width="35%">Контакты</th>
        </tr>
        <c:forEach var="insurer" items="${insurerList}">
            <tr>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td rowspan="2" width="55%"><c:out value="${insurer.name}"/></td>
                            <td width="45%">
                                <spring:url value="/insurers/{insurerId}/edit.html" var="editInsurer">
                                    <spring:param name="insurerId" value="${insurer.insurerId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(editInsurer)}" class="list-group-item list-group-item-success">
                                    <span class="glyphicon glyphicon-pencil"/>
                                    Редактировать
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <spring:url value="/insurers/{insurerId}/delete.html" var="deleteInsurer">
                                    <spring:param name="insurerId" value="${insurer.insurerId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deleteInsurer)}" class="list-group-item list-group-item-danger">
                                    <span class="glyphicon glyphicon-trash"/>
                                    Удалить</a>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>${insurer.contacts}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div style="float: left; width: 20%">
    <p align="center">
        <spring:url value="/insurers/new.html" var="newInsurer"/>
        <a href="${fn:escapeXml(newInsurer)}" class="btn btn-primary">Добавить страховщика</a>
    </p>
</div>

</body>
</html>
