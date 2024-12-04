package com.project.nasaweb.controller.user;

import com.project.nasaweb.dao.user.UserDaoImpl;
import com.project.nasaweb.service.user.IUserService;
import com.project.nasaweb.service.user.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutUser", value = "/Logout")
public class Logout extends HttpServlet {

    private IUserService userService = new UserService(new UserDaoImpl());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("LoginUser");
    }
}
