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

@WebServlet("/deleteAdmin")
public class AdminDeleteServlet extends HttpServlet {
    private ImplUser implUser;
    private JDBCConnector connector;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userDel = (User) req.getSession().getAttribute("userDel");
        if (implUser.deleteUser(userDel.getId())) {
            req.getSession().setAttribute("userDel", userDel);
            //  getServletContext().getRequestDispatcher("/list_users.jsp").forward(req,resp);
            resp.sendRedirect(req.getContextPath() + "/showUsers");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
