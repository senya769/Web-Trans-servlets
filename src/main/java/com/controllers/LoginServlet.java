package com.controllers;

import com.connection.JDBCConnector;
import com.model.User;
import com.repository.impl.ImplUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connect")
public class LoginServlet extends HttpServlet {
    private ImplUser implUser;
    private JDBCConnector connector;

    //  private final String ERROR_NOT_FOUND = "Not Found This Account";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = implUser.findByEmailAndPassword(email, password);
        // set margins for post from site
        if (user != null) {
            HttpSession session = req.getSession();
           session.setAttribute("user",user);
            //getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp); // на аккаунт
            resp.sendRedirect("http://localhost:8080/web_trans/profile.jsp");
        } else {
            req.setAttribute("isErrorNotFound", true);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        connector = new JDBCConnector();
        implUser = new ImplUser(connector);
    }
}
