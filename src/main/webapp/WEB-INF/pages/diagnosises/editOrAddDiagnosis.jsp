<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 28.12.2014
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Диагноз</title>
    
    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
    <font color="#ff4500"><h1 align="center">Введите данные диагноза</h1></font>
    
    <form:form modelAttribute="diagnosis" method="post">
        <input type="hidden" value="${diagnosis.diagnosisId}" name="diagnosisId">
        <table class="table table-striped">
            <tr>
                <td>Название:</td>
                <td>
                    <input type="text" value="${diagnosis.name}" name="name">
                </td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td>
                    <textarea cols="70" rows="12" name="text">${diagnosis.text}</textarea>
                </td>
            </tr>
            <tr>
                <td>Пациент:</td>
                <td>
                    <input type="hidden" value="${patient.patientId}" name="patientId">
                    <c:out value="${patient.fio}"/>
                </td>
            </tr>
            <tr>
                <td>Доктор:</td>
                <td>
                    <select name="doctorId">
                        <option value="0">...</option>
                        <c:forEach var="doctor" items="${doctors}">
                            <c:choose>
                                <c:when test="${doctor.doctorId==diagnosis.doctorId}">
                                    <option value="${doctor.doctorId}" selected>${doctor.fio}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${doctor.doctorId}">${doctor.fio}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-success" value="OK" name="ok">
                </td>
            </tr>
        </table>
    </form:form>
</div>

<div style="float: left; width: 20%"></div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>
