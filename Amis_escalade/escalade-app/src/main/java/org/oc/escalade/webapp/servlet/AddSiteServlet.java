package org.oc.escalade.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AddSiteServlet", urlPatterns = "/auth/addSite")
public class AddSiteServlet extends HttpServlet {
    public static final String  ADD_SITE_VIEW = "/WEB-INF/jsp/auth/addSite.jsp";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

    }
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(ADD_SITE_VIEW).forward(req, res);
    }
}
