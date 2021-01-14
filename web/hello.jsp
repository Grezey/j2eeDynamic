<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/12
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    你好 JSP<br/>
    <%=new Date().toString()%>
    <%
        List<String> words=new ArrayList<>();
        words.add("today");
        words.add("is");
        words.add("a");
        words.add("great");
        words.add("day");
    %>
    <table width="200px" align="center" border="1" cellspacing="0">
        <%
            for(String word:words){%>
        <tr>
            <td><%=word%></td>
        </tr>
        <%}
        %>
    </table>
    <jsp:include page="footer.jsp">
        <jsp:param name="year" value="2020"/>
    </jsp:include>
</body>
</html>
