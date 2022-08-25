<%@ page import="com.repository.impl.ImplUser" %>
<%@ page import="com.connection.JDBCConnector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration web-trans</title>
    <jsp:include page="navbar.jsp"/>
    <% JDBCConnector connector = new JDBCConnector();
        ImplUser implUser = new ImplUser(connector);
        Boolean duplicate = implUser.checkDuplicateNickname(request.getParameter("nickname"));
        session.setAttribute("duplicate",duplicate);
    %>
</head>
<body>
<!-- Section: Design Block -->
<section class="">
    <!-- Jumbotron -->
    <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
        <div class="container">
            <div class="row gx-lg-5 align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <h1 class="my-5 display-3 fw-bold ls-tight">
                        The best offer <br/>
                        <span class="text-primary">for your business</span>
                    </h1>
                    <p style="color: hsl(217, 10%, 50.8%)">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Eveniet, itaque accusantium odio, soluta, corrupti aliquam
                        quibusdam tempora at cupiditate quis eum maiores libero
                        veritatis? Dicta facilis sint aliquid ipsum atque?
                    </p>
                </div>
<!--<input type="tel" id="phone" name="phone" placeholder="123-45-678" pattern="^(+375)(29|25|44|33)[0-9]{3}-[0-9]{2}-[0-9]{2}" required> !-->
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="card">
                        <div class="card-body py-5 px-md-5">
                            <form action="${pageContext.request.contextPath}/registration" method="post">
                                <% if(duplicate){%>
                                <div class="alert alert-warning">
                                    <strong> Nickname is busy!</strong>
                                </div>
                                <%}%>
                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="radio" name="captionUser"
                                           id="flexRadioDefault1"  value="Individual">
                                    <label class="form-check-label" for="flexRadioDefault1">
                                        Individual
                                    </label>
                                </div>
                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="radio" name="captionUser"
                                           id="flexRadioDefault2" value="Legal entity">
                                    <label class="form-check-label" for="flexRadioDefault2">
                                    Legal entity
                                    </label>
                                    <div class="invalid-feedback">Required</div>
                                </div>

                                <div class="form-floating mb-4">
                                    <input type="text" class="form-control" id="floatingInput" name="nickname" placeholder="nick" required>
                                    <label for="floatingInput">Nickname
                                    </label>

                                </div>
                                <div class="form-text mb-4">
                                    <label for="floatingInput">Number Phone</label>
                                    <input type="tel" class="form-control" id="floatingInput1" name="number" placeholder="+375(29)-990-99-99" pattern="^(+375)(29|25|44|33)[0-9]{3}-[0-9]{2}-[0-9]{2}" required>
                                </div>
                                <!-- Email input -->
                                <div class="form-floating mb-4">
                                    <input type="email" id="form3Example3" class="form-control" name="email" placeholder="mail" required/>
                                    <label class="form-label" for="form3Example3">Email address</label>
                                </div>

                                <!-- Password input -->
                                <div class="form-floating mb-4">
                                    <input type="password" id="form3Example4" class="form-control" placeholder="*******" name="password" required/>
                                    <label class="form-label" for="form3Example4">Password</label>
                                </div>
                                <!-- Submit button -->
                                <button type="submit" class="btn btn-primary btn-block mb-4">
                                    Sign up
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Jumbotron -->
</section>
<!-- Section: Design Block -->
<jsp:include page="footer.jsp"/>
</body>
</html>
