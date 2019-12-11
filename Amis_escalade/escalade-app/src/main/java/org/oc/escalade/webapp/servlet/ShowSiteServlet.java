package org.oc.escalade.webapp.servlet;

import org.oc.escalade.business.SitesBusiness;
import org.oc.escalade.model.Site;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowSiteServlet", urlPatterns = "/showSite")
public class ShowSiteServlet extends HttpServlet {
    public static final String  SHOW_SITE_VIEW = "/WEB-INF/jsp/showSite.jsp";
    public static final String SITE_ATT = "site";

    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        SitesBusiness sitesBusiness = new SitesBusiness();
        Site site = sitesBusiness.getSiteById( req );
        req.getServletContext().setAttribute( SITE_ATT, site );

        req.getRequestDispatcher( SHOW_SITE_VIEW ).forward( req, res );
    }
}
