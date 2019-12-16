package org.oc.escalade.controlers.servlets;

import org.oc.escalade.business.WaysManager;
import org.oc.escalade.models.Site;
import org.oc.escalade.models.Way;
import org.oc.escalade.utils.RatingManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddWayServlet", urlPatterns = "/auth/addWay")
public class AddWayServlet extends HttpServlet {
    public static final String  ADD_WAY_VIEW = "/WEB-INF/jsp/auth/addWay.jsp";
    public static final String  SHOW_SECTOR_PAGE = "/showSector?id=";
    public static final String RATINGS_ATT = "ratings";
    public static final String SITE_ATT = "site";
    public static final String WAY_ATT = "way";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        WaysManager form = new WaysManager();
        Way way = form.addWay(req);
        //req.getServletContext().setAttribute(WAY_ATT, way);
        Site site = (Site) req.getServletContext().getAttribute(SITE_ATT);
        res.sendRedirect(req.getContextPath() + SHOW_SECTOR_PAGE + site.getId());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //WaysManager form = new WaysManager();
        List<String> ratingValues = RatingManager.getAllRatings();
        req.getServletContext().setAttribute(RATINGS_ATT, ratingValues);
        this.getServletContext().getRequestDispatcher(ADD_WAY_VIEW).forward(req, res);

    }
}
