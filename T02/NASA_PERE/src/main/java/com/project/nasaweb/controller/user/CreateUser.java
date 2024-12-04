package com.project.nasaweb.controller.user;
import com.project.nasaweb.dao.user.UserDaoImpl;
import com.project.nasaweb.service.user.IUserService;
import com.project.nasaweb.service.user.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreateUser", value = "/CreateUser")
public class CreateUser extends HttpServlet {

    private IUserService userService = new UserService(new UserDaoImpl());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("user/userForm.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean res = userService.register(name, email, password);
        if (res){
            response.sendRedirect("LoginUser");
        }
    }
}
