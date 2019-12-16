package org.oc.escalade.controllers.servlets;

import org.oc.escalade.business.LoginManager;
import org.oc.escalade.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final String LOGIN_VIEW = "/WEB-INF/jsp/login.jsp";
    public static final String HOME_PAGE = "/home";
    public static final String USER_ATT = "user";
    public static final String FORM_ATT = "form";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        LoginManager form = new LoginManager();
        User user = form.logUser(req);

        if( form.getErrors().isEmpty() ) {
            req.getSession().setAttribute("user", user);
            res.sendRedirect(req.getContextPath() + HOME_PAGE );
        } else {
            req.setAttribute( FORM_ATT, form );
            this.getServletContext().getRequestDispatcher( LOGIN_VIEW ).forward( req, res );
        }
    }

    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( LOGIN_VIEW ).forward( req,res );
    }
}
