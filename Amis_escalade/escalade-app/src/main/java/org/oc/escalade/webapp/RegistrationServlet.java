package org.oc.escalade.webapp;

import org.oc.escalade.business.RegistrationForm;
import org.oc.escalade.model.User;

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
    public static final String USER_ATT = "user_att";
    public static final String FORM_ATT = "form_att";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RegistrationForm form = new RegistrationForm();
        User user = form.registerUser(req);

        req.setAttribute(FORM_ATT, form);
        req.setAttribute(USER_ATT, user);

        this.getServletContext().getRequestDispatcher(REGISTRATION_VIEW).forward(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher(REGISTRATION_VIEW).forward(req, res);
    }
}
