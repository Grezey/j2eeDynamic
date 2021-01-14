<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/14
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>listHero</title>
</head>
<body>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>hp</td>
            <td>damage</td>
            <td>edit</td>
            <td>delete</td>
        </tr>
        <c:forEach items="${heros}" var="hero" varStatus="st">
            <tr>
                <td>${hero.id}</td>
                <td>${hero.name}</td>
                <td>${hero.hp}</td>
                <td>${hero.damage}</td>
                <td><a href="editHero?id=${hero.id}">edit</a>
                <td><a href="deleteHero?id=${hero.id}">delete</a>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="center">
                <a href="?start=0">[首 页]</a>
                <a href="?start=${pre}">[上一页]</a>
                <a href="?start=${next}">[下一页]</a>
                <a href="?start=${last}">[末 页]</a>
            </td>
        </tr>
    </table>
</body>
</html>
