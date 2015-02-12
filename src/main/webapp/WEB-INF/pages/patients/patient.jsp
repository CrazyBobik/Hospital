<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 26.12.2014
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Информация о пациенте</title>
    
    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
    <font color="#ff4500"><h1 align="center">${patient.fio}</h1></font>
    
    <ul>
        <dt><b>Адресс:</b></dt>
        <dd>${patient.address}</dd>
        <dt><b>Контакты:</b></dt>
        <dd>${patient.contacts}</dd>
        <dt><b>Страховщик:</b></dt>
        <dd>${patient.insurerName}</dd>
    </ul>

  
    <table class="table table-striped">
        <tr>
            <th width="40%">Диагноз</th>
            <th width="45%">Описание диагноза</th>
            <th width="20%">Доктор</th>
        </tr>
        <c:forEach var="diagnosis" items="${patient.diagnosisViewList}">
            <tr>
                <td>
                    <table class="table table-striped">
                        <tr>
                            <td rowspan="2" width="40%">${diagnosis.name}</td>
                            <td width="60%">
                                <spring:url value="/patients/{patientId}/diagnosis/{diagnosisId}/edit.html" var="editDiagnosis">
                                    <spring:param name="patientId" value="${patient.patientId}"/>
                                    <spring:param name="diagnosisId" value="${diagnosis.diagnosisId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(editDiagnosis)}" class="list-group-item list-group-item-success">
                                    <span class="glyphicon glyphicon-pencil"/>
                                    Редактировать
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <spring:url value="/patients/{patientId}/diagnosis/{diagnosisId}/delete.html" var="deleteDiagnosis">
                                    <spring:param name="patientId" value="${patient.patientId}"/>
                                    <spring:param name="diagnosisId" value="${diagnosis.diagnosisId}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deleteDiagnosis)}" class="list-group-item list-group-item-danger">
                                    <span class="glyphicon glyphicon-trash"/>
                                    Удалить
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>${diagnosis.text}</td>
                <td>
                        ${diagnosis.doctorName}<br>
                    -${diagnosis.doctorPost}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div style="float: left; width: 20%">
    <spring:url value="/patients/{patientId}/graphiks.html" var="showGraphiks">
        <spring:param name="patientId" value="${patient.patientId}"/>
    </spring:url>
    
    <spring:url value="/patients/{patientId}/edit.html" var="editPatient">
        <spring:param name="patientId" value="${patient.patientId}"/>
    </spring:url>
    
    <spring:url value="/patients/{patientId}/diagnosis/new.html" var="addDiagnosis">
        <spring:param name="patientId" value="${patient.patientId}"/>
    </spring:url>
    
    <spring:url value="/patients/{patientId}/delete.html" var="deletePatient">
        <spring:param name="patientId" value="${patient.patientId}"/>
    </spring:url>
    
    <div class="list-group">
        <a href="${fn:escapeXml(showGraphiks)}" class="list-group-item list-group-item-info">
            <span class="glyphicon glyphicon-calendar"/>
            График приемов
        </a>
        <a href="${fn:escapeXml(addDiagnosis)}" class="list-group-item list-group-item-info">
            <span class="glyphicon glyphicon-plus"/>
            Добавить диагноз
        </a>
        <a href="${fn:escapeXml(editPatient)}" class="list-group-item list-group-item-success">
            <span class="glyphicon glyphicon-pencil"/>
            Редактировать пациента
        </a>
        <a href="${fn:escapeXml(deletePatient)}" class="list-group-item list-group-item-danger">
            <span class="glyphicon glyphicon-trash"/>
            Удалить пациента
        </a>
    </div>
</div>

<jsp:include page="../parts/footer.jsp"/>
</body>
</html>
