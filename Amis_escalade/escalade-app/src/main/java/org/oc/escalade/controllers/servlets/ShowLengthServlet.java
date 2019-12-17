package org.oc.escalade.controllers.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowLengthServlet", urlPatterns = "/WEB-INF/jsp//showLength")
public class ShowLengthServlet extends HttpServlet {
    public static final String SHOW_LENGTH_VIEW = "showLength.jsp";
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher(SHOW_LENGTH_VIEW).forward( req, res );
    }
}
