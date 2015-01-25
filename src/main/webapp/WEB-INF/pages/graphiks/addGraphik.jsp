<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 10.01.2015
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Запись на прием</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Запись на прием</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
  <form:form modelAttribute="graphik" method="post">
    <table align="center">
      <tr>
        <td>Пациент:</td>
        <td>
          <select name="patientId">
            <c:forEach var="patient" items="${patients}">
              <option value="${patient.patientId}">${patient.fio}</option>
            </c:forEach>
          </select>
        </td>
      </tr>

      <tr>
        <td>Доктор:</td>
        <td>
          <select name="doctorId">
            <c:forEach var="doctor" items="${doctors}">
              <option value="${doctor.doctorId}">${doctor.fio}</option>
            </c:forEach>
          </select>
        </td>
      </tr>

      <tr>
        <td>Дата:</td>
        <td>
          <input type="date" name="date" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}" placeholder="2014/12/31">
        </td>
      </tr>

      <tr>
        <td>
          <input type="submit" value="OK" name="ok">
        </td>
      </tr>
    </table>
  </form:form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>