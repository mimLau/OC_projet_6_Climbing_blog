package org.oc.escalade.webapp.servlet;

import org.oc.escalade.business.WaysForm;
import org.oc.escalade.model.Rating;
import org.oc.escalade.model.Site;
import org.oc.escalade.model.Way;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.WatchService;
import java.util.List;

@WebServlet(name = "AddWayServlet", urlPatterns = "/auth/addWay")
public class AddWayServlet extends HttpServlet {
    public static final String  ADD_WAY_VIEW = "/WEB-INF/jsp/auth/addWay.jsp";
    public static final String  SHOW_SECTOR_PAGE = "/showSector?id=";
    public static final String RATINGS_ATT = "ratings";
    public static final String SITE_ATT = "site";
    public static final String WAY_ATT = "way";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        WaysForm form = new WaysForm();
        Way way = form.addWay(req);
        //req.getServletContext().setAttribute(WAY_ATT, way);
        Site site = (Site) req.getServletContext().getAttribute(SITE_ATT);
        res.sendRedirect(req.getContextPath() + SHOW_SECTOR_PAGE + site.getId());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        WaysForm form = new WaysForm();
        List<String> ratingValues = form.getAllRatings();
        req.getServletContext().setAttribute(RATINGS_ATT, ratingValues);
        this.getServletContext().getRequestDispatcher(ADD_WAY_VIEW).forward(req, res);

    }
}
