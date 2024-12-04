package com.project.nasaweb.Interceptor;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(servletNames = {"aproaches","createAproach", "createAsteroid", "eliminar", "saveAsteroids", "updateAsteroid"})
public class ObserverInterceptor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession();
        if (session != null && (session.getAttribute("LoggedIn") == null || !(Boolean.TRUE.equals(session.getAttribute("LoggedIn"))))) {
            httpResponse.sendRedirect("LoginUser");
            return;
        }

        String userRol = (String) session.getAttribute("userRol");
        if (userRol == null || userRol.equals("OBSERVERS")) {
            httpResponse.sendRedirect("asteroids");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}