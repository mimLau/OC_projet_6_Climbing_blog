package org.oc.escalade.webapp.servlet;

import org.oc.escalade.business.SectorsForm;
import org.oc.escalade.model.Sector;
import org.oc.escalade.model.Site;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddSectorServlet", urlPatterns = "/auth/addSector")
public class AddSectorServlet extends HttpServlet {
    public static final String  ADD_SECTOR_VIEW = "/WEB-INF/jsp/auth/addSector.jsp";
    public static final String  ADD_WAY_VIEW = "/WEB-INF/jsp/auth/addWay.jsp";
    public static final String  ADD_WAY_PAGE = "/auth/addWay";
    public static final String SECTOR_ATT = "sector";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        SectorsForm sectorsForm = new SectorsForm();
        Sector sector = sectorsForm.addSector(req);

        req.getServletContext().setAttribute(SECTOR_ATT, sector);
        //res.sendRedirect(req.getContextPath() + ADD_WAY_PAGE );
        this.getServletContext().getRequestDispatcher(ADD_SECTOR_VIEW).forward(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(ADD_SECTOR_VIEW).forward(req, res);
    }
}
