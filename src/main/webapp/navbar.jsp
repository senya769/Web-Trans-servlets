<%@ page import="com.model.User" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resource/css/navbar.css">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" id = "truck-icon" href="index.jsp">
        <img src="https://cdn-icons-png.flaticon.com/512/819/819438.png" width="30" height="30" alt="">
    </a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Web-Trans</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="#">Pricing</a>
            <a class="nav-item nav-link disabled" href="#">Disabled</a>
        </div>
    </div>
    <% User user = (User) session.getAttribute("user");
        if( user == null ){ %>
    <a href="login.jsp" type="button" class="btn btn-outline-primary" >sing in</a>
    <a href ="registration.jsp" type="button" class="btn btn-outline-primary">sing up</a>
<% } else {%>
        <div class="dropdown">
            <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                <%= user.getName()%>
            </a>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <li><a class="dropdown-item" href="profile.jsp">Account</a></li>
                <li><a class="dropdown-item" href="#">test</a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">logout</a></li>
            </ul>
        </div>
    <% }%>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</html>