package com.project.nasaweb.views;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "index", value = "/")
public class index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>index</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>index</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    public void destroy() {
    }

}
