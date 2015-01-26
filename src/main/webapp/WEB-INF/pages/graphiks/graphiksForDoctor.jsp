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
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Запись на прием</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float: left; width: 59%">
  <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%"
         align="center">
    <tr>
      <th width="35%">Доктор</th>
      <th width="35%">Пациент</th>
      <th width="30%">Дата</th>
    </tr>
    <c:forEach var="graphik" items="${doctor.graphikViewList}">
      <tr>
        <td>${graphik.doctorName}</td>
        <td>${graphik.fio}</td>
        <td>${graphik.formatDate}</td>
      </tr>
    </c:forEach>
  </table>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>

