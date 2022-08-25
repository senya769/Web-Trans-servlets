package com.util;

import com.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/showUsers")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
      /*User user = (User) request.getAttribute("user");
      if(user.getStatusUser() == "Admin"){}
      проверка на админа
      */
        chain.doFilter(request, response);

    }
}
