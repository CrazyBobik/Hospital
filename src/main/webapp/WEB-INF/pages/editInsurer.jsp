<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 30.12.2014
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Страховщик</title>
</head>
<body bgcolor="#ffe4c4">

<div>
  <font color="#dc143c"><h1 align="center">Введите данные страховщика</h1></font>
</div>

<div style="float:left; width: 20%">
  <p align="left">
    <a href="/main"><b>Пациенты</b></a><br>
    <a href="/doctors"><b>Доктора</b></a><br>
    <a href="/insurers"><b>Страховщики</b></a><br>
  </p>
</div>

<div style="float:left; width: 59%">
  <form action="/editInsurer" method="post">
    <input type="hidden" value="${insurer.insurerId}" name="insurerId">
    <table align="center">
      <tr>
        <td>Название:</td>
        <td>
          <input type="text" value="${insurer.name}" name="name">
        </td>
      </tr>
      <tr>
        <td>Контакты:</td>
        <td>
          <textarea cols="70" rows="5" name="contacts">${insurer.contacts}</textarea>
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

