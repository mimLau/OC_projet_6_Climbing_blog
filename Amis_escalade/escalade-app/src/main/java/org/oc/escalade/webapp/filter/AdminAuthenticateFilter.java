package org.oc.escalade.webapp.filter;

import org.oc.escalade.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthenticateFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, res);

        HttpServletRequest HttpReq = (HttpServletRequest) req;
        HttpServletResponse HttpRes = (HttpServletResponse) res;

        User user = (User) HttpReq.getSession().getAttribute("user");
        final String HOME_PAGE = "/home";

        if (user != null) {
            String username = user.getUsername();
            if (user != null && username != "") {
                if (user.getRole().equals("admin")) {
                    System.out.println("Bienvenue " + username + "!");
                    chain.doFilter(req, res);
                } else {
                    System.out.println("Vous n'avez pas les droits d'accès pour cette page!");
                    HttpRes.sendRedirect(HttpReq.getContextPath() + HOME_PAGE);
                }
            } else {
                System.out.println("Vous n'êtes pas authentifié!");
                HttpRes.sendRedirect(HttpReq.getContextPath() + HOME_PAGE);
            }
        }

    }
}
