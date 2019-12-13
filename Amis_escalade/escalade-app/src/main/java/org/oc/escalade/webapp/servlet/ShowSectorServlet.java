package org.oc.escalade.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowSecteurServlet", urlPatterns = "/showSector")
public class ShowSectorServlet extends HttpServlet {
    public static final String SHOW_SECTOR_VIEW = "/WEB-INF/jsp/showSector.jsp";
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(SHOW_SECTOR_VIEW).forward(req, res);
    }
}
