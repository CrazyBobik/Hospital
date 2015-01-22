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
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">${patient.fio}</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
  <table cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
    <tr>
      <td width="50%">
        <spring:url value="/patients/{patientId}/edit.html" var="editPatient">
          <spring:param name="patientId" value="${patient.patientId}"/>
        </spring:url>
        <a href="${fn:escapeXml(editPatient)}">Редактировать пациента</a>
      </td>
      <td width="50%" align="right">
        <spring:url value="/patients/{patientId}/delete.html" var="deletePatient">
          <spring:param name="patientId" value="${patient.patientId}"/>
        </spring:url>
        <a href="${fn:escapeXml(deletePatient)}">Удалить пациента</a>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <dl>
          <dt><b>Адресс:</b></dt>
          <dd>${patient.address}</dd>
          <dt><b>Контакты:</b></dt>
          <dd>${patient.contacts}</dd>
          <dt><b>Страховщик:</b></dt>
          <dd>${patient.insurerName}</dd>
        </dl>
      </td>
    </tr>
    <tr>
      <td>
        <spring:url value="/patients/{patientId}/graphiks.html" var="showGraphiks">
          <spring:param name="patientId" value="${patient.patientId}"/>
        </spring:url>
        <a href="${fn:escapeXml(showGraphiks)}">График приемов</a>
      </td>
      <td align="right">
        <spring:url value="/patients/{patientId}/diagnosises/new.html" var="addDiagnosis">
          <spring:param name="patientId" value="${patient.patientId}"/>
        </spring:url>
        <a href="${fn:escapeXml(addDiagnosis)}">Добавить диагноз</a>
      </td>
    </tr>
  </table>
  
  <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
    <tr>
      <th width="30%">Диагноз</th>
      <th width="50%">Описание диагноза</th>
      <th width="20%">Доктор</th>
    </tr>
    <c:forEach var="diagnosis" items="${patient.diagnosisViewList}">
      <tr>
        <td>
            <table cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
              <tr>
                <td rowspan="2" width="50%">${diagnosis.name}</td>
                <td width="50%">
                  <spring:url value="/patients/{patientId}/diagnosis/edit.html" var="editDiagnosis">
                    <spring:param name="diagnosisId" value="${diagnosis.diagnosisId}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(editDiagnosis)}">Редактировать</a>
                </td>
              </tr>
              <tr>
                <td>
                  <spring:url value="/patients/{patientId}/diagnosis/delete.html" var="deleteDiagnosis">
                    <spring:param name="diagnosisId" value="${diagnosis.diagnosisId}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(deleteDiagnosis)}">Удалить</a>
                </td>
              </tr>
            </table>
        </td>
        <td>${diagnosis.text}</td>
        <td>
          <dl>
            <dt>${diagnosis.doctorPost}</dt>
            <dd>${diagnosis.doctorName}</dd>
          </dl>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
