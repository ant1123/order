<%--
  Created by IntelliJ IDEA.
  User: AJ
  Date: 14.12.13
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
     ERROR!!!
<%
    Exception e=(Exception) request.getAttribute("exeption");
    if(e!=null)  {
        %><%=e.getMessage()%><%
    }
%>
</body>
</html>