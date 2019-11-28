package org.oc.escalade.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final String LOGIN_VIEW = "/jsp/login.jsp";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(LOGIN_VIEW).forward(req,res);
    }
}
