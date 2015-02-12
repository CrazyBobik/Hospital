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
    
    <jsp:include page="../parts/css.jsp"/>
</head>
<body>

<jsp:include page="../parts/head.jsp"/>

<jsp:include page="../parts/menu.jsp"/>

<div style="float:left; width: 59%">
    <font color="#ff4500"><h1 align="center">Введите данные доктора</h1></font>
    
  <form:form modelAttribute="doctor" method="post">
    <input type="hidden" value="${doctor.doctorId}" name="doctorId">
    <table class="table table-striped">
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
