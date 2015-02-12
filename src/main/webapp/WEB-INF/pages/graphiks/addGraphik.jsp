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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
    
  <form:form modelAttribute="graphik" method="post">
    <table class="table table-striped">
      <tr>
        <td width="40%">Пациент:</td>
        <td width="60%">
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
          <input type="date" maxlength="10" name="date" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}"
                 placeholder="2014/12/31">
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="OK" name="ok" class="btn btn-success">
        </td>
      </tr>
    </table>
  </form:form>
</div>

<div style="float: left; width: 20%"></div>

<jsp:include page="../parts/footer.jsp"/>
</body>
</html>