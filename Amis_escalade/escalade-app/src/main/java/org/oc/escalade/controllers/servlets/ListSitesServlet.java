package org.oc.escalade.controllers.servlets;

import org.oc.escalade.business.SitesManager;
import org.oc.escalade.models.Site;
import org.oc.escalade.utils.RatingManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListSitesServlet", urlPatterns = "/listSites")
public class ListSitesServlet extends HttpServlet {
    public static final String SITE_VIEW = "/WEB-INF/jsp/listSites.jsp";
    public static final String ALL_SITES_ATT = "all_sites";
    public static final String SEARCHED_SITES_ATT = "searched_sites";
    public static final String COUNTRY_REGION_ATT = "countryRegions";
    public static final String RATINGS_ATT = "ratings";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        SitesManager sitesManager = new SitesManager();
        List<Site> searchedSites = sitesManager.searchSite( req );

        req.setAttribute(SEARCHED_SITES_ATT, searchedSites);
        this.getServletContext().getRequestDispatcher(SITE_VIEW).forward(req, res);
    }

    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        List<String> ratingValues = RatingManager.getAllRatings();
        req.getServletContext().setAttribute(RATINGS_ATT, ratingValues);

        SitesManager sitesManager = new SitesManager();
        List<Site> allSites = sitesManager.getAllSites();
        Map<String, List<String>> countriesWithRegions = sitesManager.listOfCountriesRegions();
        req.getServletContext().setAttribute(COUNTRY_REGION_ATT, countriesWithRegions);
        req.setAttribute(ALL_SITES_ATT, allSites);
        this.getServletContext().getRequestDispatcher(SITE_VIEW).forward(req, res);
    }
}
