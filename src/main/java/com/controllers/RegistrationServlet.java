package com.controllers;

import com.connection.JDBCConnector;
import com.model.BuilderUser;
import com.model.User;
import com.repository.impl.ImplUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private ImplUser implUser;
    private JDBCConnector connector;

    public RegistrationServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession sessionReg = req.getSession();
        String email = req.getParameter("email");
        String pasw = req.getParameter("password");
        String name = (req.getParameter("nickname"));
        String role = (req.getParameter("captionUser"));

        User user = new BuilderUser().email(email)
                .password(pasw)
                .name(name)
                .numberPhone("null")
                .roleUser("role")
                .statusUser("user").build();
        //   user.setNumberPhone("null");
        //   user.setStatusUser("User");
        if (implUser.createUser(user)) {
            sessionReg.setAttribute("user",user);
            resp.sendRedirect("http://localhost:8080/web_trans/profileUser.jsp");
        }

    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
