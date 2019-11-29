package org.oc.escalade.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.PanelUI;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    public static final String REGISTRATION_VIEW = "/jsp/registration.jsp";
    public static final String USERNAME_FIELD = "username";
    public static final String EMAIL_FIELD = "email";
    public static final String PASS_FIELD = "password";
    public static final String CONF_PASS_FIELD = "confPass";
    public static final String FIRSTNAME_FIELD = "firstname";
    public static final String LASTNAME_FIELD = "lastname";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_FIELD);
        String email = req.getParameter(EMAIL_FIELD);
        String pass = req.getParameter(PASS_FIELD);
        String confPass = req.getParameter(CONF_PASS_FIELD);
        String firstname = req.getParameter(FIRSTNAME_FIELD);
        String lastname = req.getParameter(LASTNAME_FIELD);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher(REGISTRATION_VIEW).forward(req, res);
    }
}
