
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login web-trans</title>
    <jsp:include page="navbar.jsp"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/connect" method="POST">
    <!-- Section: Design Block -->
    <section class="bottom-marg">
        <!-- Jumbotron -->
        <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
            <div class="container">
                <div class="row gx-lg-5 align-items-center">
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <h1 class="my-5 display-3 fw-bold ls-tight">
                            The best service <br />
                            <span class="text-primary">for monitoring cargo transportation</span>
                        </h1>
                        <p style="color: hsl(217, 10%, 50.8%)">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Eveniet, itaque accusantium odio, soluta, corrupti aliquam
                            quibusdam tempora at cupiditate quis eum maiores libero
                            veritatis? Dicta facilis sint aliquid ipsum atque?
                        </p>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <div class="card">
                            <div class="card-body py-5 px-md-5">
                                <form>
                                    <% if (request.getAttribute("isErrorNotFound")!=null){%>
                                    <h3>Account is not found! Try again...</h3>
                                    <%}%>
                                    <!-- Email input -->
                                    <div class="form-floating mb-4">
                                        <input type="text" class="form-control" id="floatingInput" placeholder="email" name="email" >
                                        <label for="floatingInput">Email address</label>
                                    </div>
                                    <!-- Password input -->
                                    <div class="form-floating mb-4">
                                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                                        <label for="floatingPassword">Password</label>
                                    </div>
                                    <!-- Submit button -->
                                    <button type="submit" value="Login" class="btn btn-primary btn-block mb-4">
                                      Login
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Section: Design Block -->
</form>
<div class="test">
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
