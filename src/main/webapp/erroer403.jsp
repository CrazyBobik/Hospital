<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 24.02.2015
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ошибка</title>
    
    <jsp:include page="WEB-INF/pages/parts/css.jsp"/>
</head>
<body>

<jsp:include page="WEB-INF/pages/parts/head.jsp"/>

<jsp:include page="WEB-INF/pages/parts/menu.jsp"/>

<div class="alert alert-danger" style="float: left; width: 59%">
    <h1 align="center">К сожалению у Вас недостаточно прав</h1>
</div>

<div style="float: left; width: 20%"></div>

<jsp:include page="WEB-INF/pages/parts/footer.jsp"/>

</body>
</html>
