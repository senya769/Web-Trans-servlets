<%@ page import="com.connection.JDBCConnector" %>
<%@ page import="com.repository.impl.ImplUser" %>
<%@ page import="com.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 03.08.2022
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list users Admin-panel</title>
    <%
        ImplUser implUser = (ImplUser) request.getSession().getAttribute("impl");
        List<User> list = (List<User>) request.getSession().getAttribute("userList");
    %>
    <jsp:include page="navbar.jsp"/>
</head>
<body>
<%--
<%if(userDel!= null ){%>
<div class="alert alert-success" role="alert">
    User  <a href="#" class="alert-link"> <%= userDel.getName()%> </a> id (<%= userDel.getId()%>) is delete!
</div>
<%}%>--%>
<table class="table table-hover">
    <thead>
    <tr>
        <div class="head-table">
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">NUMBER</th>
            <th scope="col">ROLE</th>
            <th scope="col">STATUS</th>
            <th scope="col">PANEL</th>
        </div>
    </tr>
    </thead>
    <tbody>
        <%for(User u : list){%>
    <tr>
        <th><%=u.getId()%>
        <td><%=u.getName()%>
        <td><%=u.getEmail()%>
        <td><%=u.getNumberPhone()%>
        <td><%=u.getRoleUser()%>
        <td><%=u.getStatusUser()%>
        <td>
        <% if(!Objects.equals(u.getStatusUser(), "Admin")){%>
                <form action="deleteAdmin" method="post">
                    <%request.getSession().setAttribute("userDel",u);%>
                        <button type="submit" class="badge badge-danger">delete</button>
                </form>
<%}%>
        </td>
    </tr>
        <%}%>
</table>
</body>
</html>
