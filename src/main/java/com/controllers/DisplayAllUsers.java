package com.controllers;

import com.connection.JDBCConnector;
import com.model.User;
import com.repository.impl.ImplUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/showUsers")
public class DisplayAllUsers extends HttpServlet {
    private ImplUser implUser;
    private JDBCConnector connector;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userSession = (User) req.getSession().getAttribute("user");
        if (Objects.equals(userSession.getStatusUser(), "Admin")) {
            List<User> userList = implUser.getListUsers();
            if (userList != null) {
                req.getSession().setAttribute("userList", userList);
                req.getSession().setAttribute("impl", implUser);
                getServletContext().getRequestDispatcher("/list_users.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
