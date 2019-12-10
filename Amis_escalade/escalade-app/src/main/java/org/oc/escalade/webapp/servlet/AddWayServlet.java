package org.oc.escalade.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddWayServlet", urlPatterns = "/auth/addWay")
public class AddWayServlet extends HttpServlet {
    public static final String  ADD_WAY_VIEW = "/WEB-INF/jsp/auth/addWay.jsp";
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(ADD_WAY_VIEW).forward(req, res);

    }
}
