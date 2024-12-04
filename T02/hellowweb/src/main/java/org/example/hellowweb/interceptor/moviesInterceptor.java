package org.example.hellowweb.interceptor;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(servletNames = {"CreateServlet","DeleteServlet","FirstMovieServlet","helloServlet","MovieByIDServlet","MoviesServlet","UpdateServlet"})
public class moviesInterceptor implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpRespons = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();

        if (session != null && (session.getAttribute("login") == null) || !(Boolean.TRUE.equals(session.getAttribute("login")))) {
            httpRespons.sendRedirect("login");
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        Filter.super.destroy();
    }

}
