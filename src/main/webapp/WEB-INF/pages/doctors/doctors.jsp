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
    
    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Доктора</h1></font>
  
    <table class="table table-striped">
        <tr>
            <th width="65%">Ф.И.О.</th>
            <th width="35%">Пост</th>
        </tr>
        <c:forEach var="doctor" items="${doctorList}">
            <tr>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td rowspan="3" width="55%"><c:out value="${doctor.fio}"/></td>
                            <td width="45%">
                                <spring:url value="/doctors/{doctorId}/graphiks.html" var="graphikForDoctor">
                                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(graphikForDoctor)}" class="list-group-item list-group-item-info">
                                    <span class="glyphicon glyphicon-calendar"/>
                                    График приемов
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <spring:url value="/doctors/{doctorId}/edit.html" var="editDoctor">
                                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(editDoctor)}" class="list-group-item list-group-item-success">
                                    <span class="glyphicon glyphicon-pencil"/>
                                    Редактировать
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <spring:url value="/doctors/{doctorId}/delete.html" var="deleteDoctor">
                                    <spring:param name="doctorId" value="${doctor.doctorId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deleteDoctor)}" class="list-group-item list-group-item-danger">
                                    <span class="glyphicon glyphicon-trash"/>
                                    Удалить
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>${doctor.post}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div style="float: left; width: 20%">
    <div class="list-group">
        <spring:url value="/doctors/new.html" var="newDoctor"/>
        <a href="${fn:escapeXml(newDoctor)}" class="list-group-item list-group-item-info">
            <span class="glyphicon glyphicon-plus"/>
            Добавить доктора
        </a>
    </div>
</div>

<jsp:include page="../parts/footer.jsp"/>
</body>
</html>
