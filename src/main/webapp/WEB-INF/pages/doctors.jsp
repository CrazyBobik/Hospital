<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Доктора</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Доктора</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
    <a href="/addgraphik"><b>Записатся на прием</b></a>
  </p>
</div>

<div style="float: left; width: 59%">
  <form action="/doctors" method="post">
    <p align="right">
      <input type="submit" value="График приемов" name="graphik">
      <input type="submit" value="Добавить" name="add">
      <input type="submit" value="Редактировать" name="edit">
      <input type="submit" value="Удалить" name="del">
    </p>
    <table bordercolor="#8b0000" bgcolor="#ffeedd" cellpadding="5" cellspacing="2" border="2" width="100%" align="center">
      <tr>
        <th width="50%">Ф.И.О.</th>
        <th width="50%">Пост</th>
      </tr>
      <c:forEach var="doctor" items="${doctorList}">
        <tr>
          <td>
            <input type="radio" value="${doctor.doctorId}" name="doctorId">
              ${doctor.fio}
          </td>
          <td>${doctor.post}</td>
        </tr>
      </c:forEach>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>

</body>
</html>
