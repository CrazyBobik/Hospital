<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Доктор</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные доктора</h1></font>
</div>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
  <form:form modelAttribute="doctor" method="post">
    <input type="hidden" value="${doctor.doctorId}" name="doctorId">
    <table align="center">
      <tr>
        <td>Ф.И.О.:</td>
        <td>
          <input type="text" value="${doctor.fio}" name="fio">
        </td>
      </tr>
      <tr>
        <td>Пост:</td>
        <td>
          <input type="text" value="${doctor.post}" name="post">
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="OK" name="ok">
        </td>
      </tr>
    </table>
  </form:form>
</div>

<div style="float: left; width: 20%"></div>


</body>
</html>
