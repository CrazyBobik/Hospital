<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 22.01.2015
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div style="float:left; width: 20%">
    
        <div style="width: 80%; height: 10%">
            <sec:authorize access="isAuthenticated()">
                <font color="#ff4500">
                    <h4 align="center">Здравствуйте <b><sec:authentication property="principal.username"/></b></h4>
                </font>
                <p align="center">
                    <a href="/logout" class="btn btn-warning">Выйти</a>
                </p>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <font color="#ff4500">
                    <h4 align="center">Здравствуйте <b>Гость</b></h4>
                </font>
                <p align="center">
                    <a href="/login.jsp" class="btn btn-primary">Войти</a>
                </p>
            </sec:authorize>
        </div>
    
    
    <div class="list-group">
        <p style="width: 80%; float: left">
            <a href="/" class="list-group-item">
                <span class="glyphicon glyphicon-home"/>
                <b>На главную</b>
            </a>

            <a href="/patients" class="list-group-item">
                <span class="glyphicon glyphicon-user"/>
                <b>Пациенты</b>
            </a>

            <a href="/doctors" class="list-group-item">
                <span class="glyphicon glyphicon-briefcase"/>
                <b>Доктора</b>
            </a>
            <a href="/insurers" class="list-group-item">
                <span class="glyphicon glyphicon-list-alt"/>
                <b>Страховщики</b>
            </a>
            <a href="/graphiks/new" class="list-group-item">
                <span class="glyphicon glyphicon-time"/>
                <b>Записатся на прием</b>
            </a>
        </p>
    </div>
</div>
