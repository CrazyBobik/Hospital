<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 09.01.2015
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Запись на прием</title>
    
    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Запись на прием</h1></font>
    
    <table class="table table-striped">
        <tr>
            <th width="30%">Доктор</th>
            <th width="35%">Пациент</th>
            <th width="35%">Дата</th>
        </tr>
        <c:forEach var="graphik" items="${patient.graphikViewList}">
            <tr>
                <td>${graphik.doctorName}</td>
                <td>${graphik.fio}</td>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td width="40%">
                                <c:out value="${graphik.formatDate}"/>
                            </td>
                            <td width="60%">
                                <spring:url value="/patients/{patientId}/graphiks/{graphikId}/delete.html" var="deleteGraphik">
                                    <spring:param name="patientId" value="${patient.patientId}"/>
                                    <spring:param name="graphikId" value="${graphik.graphikId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deleteGraphik)}" class="list-group-item list-group-item-danger">
                                    <span class="glyphicon glyphicon-trash"/>
                                    Удалить
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div style="float: left; width: 20%"></div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>

