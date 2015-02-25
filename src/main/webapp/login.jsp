<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 25.12.2014
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Вход</title>
    
    <jsp:include page="WEB-INF/pages/parts/css.jsp"/>
</head>
<body>

<jsp:include page="WEB-INF/pages/parts/head.jsp"/>

<jsp:include page="WEB-INF/pages/parts/menu.jsp"/>

<div style="float: left; width: 59%">
    <font color="#ff4500"><h1 align="center">Войдите в систему для получения дополнительных прав</h1></font>

    <c:if test="${not empty param.error}">
    <font color="red"><h5 align="center">Ошибка
        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</h5></font>
    </c:if>
    
    <div style="width: 40%; margin: 0 auto">
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <input type="text" class="form-control" name="j_username" placeholder="Логин">
            <input type="password" class="form-control" name="j_password" placeholder="Пароль">
            <button class="btn btn-primary btn-block" type="submit">Войти</button>
        </form>
    </div>
</div>

<div style="float: left; width: 20%">
</div>

<jsp:include page="WEB-INF/pages/parts/footer.jsp"/>

</body>
</html>