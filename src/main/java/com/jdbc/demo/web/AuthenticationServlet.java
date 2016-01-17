package com.jdbc.demo.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 14-Nov-15.
 */

@WebServlet(urlPatterns = "/auth")
public class AuthenticationServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Cookie authCookie = new Cookie("user", user);
        authCookie.setMaxAge(45*60);
        response.addCookie(authCookie);
        response.sendRedirect("/drivers.jsp");

    }
}
