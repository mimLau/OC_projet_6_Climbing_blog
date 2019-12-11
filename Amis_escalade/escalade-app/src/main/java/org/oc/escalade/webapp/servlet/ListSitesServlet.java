package org.oc.escalade.webapp.servlet;

import org.oc.escalade.business.SitesBusiness;
import org.oc.escalade.model.Site;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListSitesServlet", urlPatterns = "/listSites")
public class ListSitesServlet extends HttpServlet {
    public static final String SITE_VIEW = "/WEB-INF/jsp/listSites.jsp";
    public static final String SITES_ATT = "sites";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        SitesBusiness siteBu = new SitesBusiness();
        List<Site> allSites = siteBu.getAllSites();
        req.setAttribute(SITES_ATT, allSites);
        this.getServletContext().getRequestDispatcher(SITE_VIEW).forward(req, res);
    }
}