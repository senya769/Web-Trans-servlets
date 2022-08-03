<%@ page import="com.model.User" %>
<%@ page import="com.repository.impl.ImplUser" %>
<%@ page import="com.connection.JDBCConnector" %>
<%@ page import="java.util.Objects" %><%--
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
    <% User user = (User) session.getAttribute("user");
        JDBCConnector connector = new JDBCConnector();
        ImplUser implUser = new ImplUser(connector);%>
</head>
<body>
<section class="vh-100" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-12 col-xl-6">

                <div class="card" style="border-radius: 15px;">
                    <div class="text-lg-start">
                        <a type="button" href="update_profile.jsp" class="btn btn-primary">
                            Edit acc
                        </a>
                        <a type="button" href="delete" class="btn btn-primary btn-rounded ">
                            Delete Account
                        </a>
                    </div>
                    <div class="card-body text-center">
                        <div class="mt-3 mb-4">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                                 class="rounded-circle img-fluid" style="width: 100px;"/>
                        </div>

                        <h4 class="mb-2"><%= user.getName()%>
                        </h4>
                        <p class="text-muted mb-4">@<%=user.getRoleUser()%> <span class="mx-2">|</span> <a
                                href="#"><%=user.getEmail()%>
                        </a></p>
                        <%if (Objects.equals(user.getStatusUser(), "Admin")) {%>
                        <div class="dropdown">
                            <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Delete ID
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <li><input type="text" class="form-control" name="deleteById" placeholder="id"
                                           required/>
                                </li>
                            </ul>
                        </div>
                        <% }%>

                        <div class="d-flex justify-content-between text-center mt-5 mb-2">
                            <div>
                                <p class="mb-2 h5">Number Phone</p>
                                <p class="text-muted mb-0"><%=user.getNumberPhone()%>
                                </p>
                            </div>
                            <div class="px-3">
                                <p class="mb-2 h5">Status</p>
                                <p class="text-muted mb-0"><%=user.getStatusUser()%>
                                </p>
                            </div>
                            <div>
                                <p class="mb-2 h5">ID</p>
                                <p class="text-muted mb-0"><%=user.getId()%>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>
