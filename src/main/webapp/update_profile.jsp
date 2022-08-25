<%@ page import="com.model.User" %>
<%@ page import="com.repository.impl.ImplUser" %>
<%@ page import="com.connection.JDBCConnector" %><%--
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
                    <div class="card-body text-center">
                        <div class="mt-3 mb-4">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                                 class="rounded-circle img-fluid" style="width: 100px;" alt="avatar"/>
                            <form>
                                <div class="form-group">
                                    <label for="exampleFormControlFile1">Example file input</label>
                                    <input type="image" class="form-control-file" id="exampleFormControlFile1" alt="">
                                </div>
                            </form>
                        </div>
                        <form action="${pageContext.request.contextPath}/update" method="Post">
                            <div class="form-text mb-4">
                                <p class="mb-2 h5">Nickname</p>
                                <input type="text" class="form-control" name="nickname" value="<%= user.getName()%>"
                                       required>
                            </div>
                            <div class="form-text mb-4">
                                <p class="mb-2 h5">Number Phone</p>
                                <input type="text" class="form-control" name="number"
                                       value="<%= user.getNumberPhone()%>" required>
                            </div>
                            <div class="form-text mb-4">
                                <p class="mb-2 h5">Email</p>
                                <input type="text" class="form-control" name="email" value="<%= user.getEmail()%>"
                                       required>
                            </div>
                            <div class="form-text mb-4">
                                <p class="mb-2 h5">Password</p>

                                <input for="password-input" type="text" class="form-control" id="password-input"
                                       name="password" value="<%= user.getPassword()%>" required/>
                                <a href="#" class="password-control"></a>
                            </div>

                            <button type="submit" class="btn btn-primary btn-block mb-4">
                                Save change
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>
