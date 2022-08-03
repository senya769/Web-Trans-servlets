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
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    ImplUser implUser;
    JDBCConnector connector;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userSession = (User) req.getSession().getAttribute("user");
        String nickName = req.getParameter("nickname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String number = req.getParameter("number");
        /*User user = new BuilderUser()
                .id(userSession.getId())
                .name(nickName)
                .numberPhone(number)
                .email(email).
                password(password).build();*/
        userSession.setName(nickName);
        userSession.setEmail(email);
        userSession.setNumberPhone(number);
        userSession.setPassword(password);
        if (implUser.updateUser(userSession)) {
            req.getSession().setAttribute("user",userSession);
            getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/update_profile.jsp").forward(req, resp);
        }

    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
