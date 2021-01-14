<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/13
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
    <%
       pageContext.setAttribute("name","gareen");
    %>
    <%=pageContext.getAttribute("name")%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:set var="heros" value="塔姆,艾克;巴德|雷克赛!卡莉丝塔" />

    <c:forTokens items="${heros}" delims=":;|!" var="hero">
        <c:out value="${hero}" /> <br />
    </c:forTokens>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>

    <%
        Date now = new Date();
        pageContext.setAttribute("now",now);
    %>

    完整日期: <fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br>
    完整时间: <fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br>
    常见格式: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>
