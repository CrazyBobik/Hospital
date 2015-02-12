<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 25.12.2014
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Приветствуем =)</title>
    
    <jsp:include page="parts/css.jsp"/>
</head>
<body>

<jsp:include page="parts/head.jsp"/>

<jsp:include page="parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Приветствуем в нашей больнице</h1></font>
    
    <spring:url value="/resources/images/foto_1.jpg" var="img"/>
    <img src="${img}" width="75%" height="45%" align="center">
</div>

<div style="float: left; width: 20%"></div>

<jsp:include page="parts/footer.jsp"/>

</body>
</html>
