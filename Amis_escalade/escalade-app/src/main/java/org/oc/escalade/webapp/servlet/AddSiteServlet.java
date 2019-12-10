package org.oc.escalade.webapp.servlet;

import org.oc.escalade.business.SitesBusiness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "AddSiteServlet", urlPatterns = "/auth/addSite")
public class AddSiteServlet extends HttpServlet {
    public static final String  ADD_SITE_VIEW = "/WEB-INF/jsp/auth/addSite.jsp";
    public static final String SITE_ATT = "sites";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

    }
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        SitesBusiness site = new SitesBusiness();
        Map<String, List<String>> countriesWithRegions = site.listOfCountriesRegions();
        req.setAttribute(SITE_ATT, countriesWithRegions);
        System.out.println("Taille de countriesWithRegions: " + countriesWithRegions.size());

        this.getServletContext().getRequestDispatcher(ADD_SITE_VIEW).forward(req, res);
    }
}
