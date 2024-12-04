package com.project.nasaweb.controller.user;

import com.project.nasaweb.dao.user.UserDaoImpl;
import com.project.nasaweb.model.User;
import com.project.nasaweb.service.user.IUserService;
import com.project.nasaweb.service.user.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {
    private IUserService userService =  new UserService(new UserDaoImpl());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("user/userLogin.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("username") == null && request.getParameter("password") == null) {
            request.setAttribute("Error", "No have Username or Password");
            request.getRequestDispatcher("user/userLogin.jsp").forward(request, response);
            return;
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User userLogin = userService.login(email, password);
        if (userLogin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("LoggedIn", true);
            session.setAttribute("userID", userLogin.getId());
            session.setAttribute("userName", userLogin.getName());
            session.setAttribute("userRol", userLogin.getRol().getRole());
            response.sendRedirect("asteroids");
            return;
        }
        request.setAttribute("Error", "Invalid email or password");
        request.getRequestDispatcher("user/userLogin.jsp").forward(request, response);

    }
}
