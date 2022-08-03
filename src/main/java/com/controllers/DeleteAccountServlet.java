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

@WebServlet("/delete")
public class DeleteAccountServlet extends HttpServlet {
    private ImplUser implUser;
    private JDBCConnector connector;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(implUser.deleteUser(user.getId())){
            req.getSession().invalidate();
            resp.sendRedirect("http://localhost:8080/web_trans/");

        }
        else {
            getServletContext().getRequestDispatcher("/profile.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(implUser.deleteUser(user.getId())){
            resp.sendRedirect("http://localhost:8080/web_trans/");
        }
        else {
            getServletContext().getRequestDispatcher("/profile.jsp").forward(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
