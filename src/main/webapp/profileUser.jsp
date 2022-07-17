<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15.07.2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web-trans account</title>
    <jsp:include page="navbar.jsp"/>
</head>
<body>
SUCCESS

<h1>$</h1>
${role}
${email}
<a href="${pageContext.request.contextPath}/logout" type="button" class="btn btn-outline-primary" >logout </a>
<h2>
    <% User user = (User) session.getAttribute("user");%>
 email   <%= user.getEmail()%>
  pass   <%= user.getPassword()%>
    id <%= user.getId()%>
</h2>
<jsp:include page="footer.jsp"/>
</body>
</html>
