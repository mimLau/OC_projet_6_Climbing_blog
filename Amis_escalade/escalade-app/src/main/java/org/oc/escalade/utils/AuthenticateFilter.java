package org.oc.escalade.utils;

import org.oc.escalade.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthenticateFilter", urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest HttpReq = (HttpServletRequest) req;
        User user = (User) HttpReq.getSession().getAttribute("user");
        String username = user.getUsername();


        if (username != null && username != "") {

            System.out.println("Bienvenue " + user + "!");
            chain.doFilter(req, resp);
        } else {

            System.out.println("Vous n'êtes pas authentifié!");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }
    }
}
