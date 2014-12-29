<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 29.12.2014
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Доктор</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные доктора</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
  </p>
</div>

<div style="float:left; width: 59%">
  <form action="/editDoctor" method="post">
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
        <td>
          <input type="submit" value="OK" name="ok">
        </td>
        <td>
          <input type="submit" value="Отмена" name="cancel">
        </td>
      </tr>
    </table>
  </form>
</div>

<div style="float: left; width: 20%"></div>


</body>
</html>
