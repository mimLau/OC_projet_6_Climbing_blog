package org.oc.escalade.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    public static final String REGISTRATION_VIEW = "/jsp/registration.jsp";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher(REGISTRATION_VIEW).forward(req, res);
    }
}
