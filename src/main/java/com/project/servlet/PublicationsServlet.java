package com.project.servlet;

import com.project.dao.impl.DefaultPublicationDao;
import com.project.service.PublicationService;
import com.project.util.DbHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/publications")
public class PublicationsServlet extends HttpServlet {
    private PublicationService publicationService;
    private final DbHelper dbHelper = new DbHelper();
    private final DefaultPublicationDao defaultPublicationDao = new DefaultPublicationDao(dbHelper);

    @Override
    public void init(ServletConfig config) throws ServletException {
        publicationService = new PublicationService(defaultPublicationDao, dbHelper);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listOfPublication", publicationService.getAllPublications());
        req.getRequestDispatcher("/publications.jsp").forward(req, resp);
    }
}
