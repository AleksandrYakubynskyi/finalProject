package com.project.servlet;

import com.project.constant.Attributes;
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

@WebServlet("/removePublication")
public class RemovePublicationServlet extends HttpServlet {
    private PublicationService publicationService;
    private final DbHelper dbHelper = new DbHelper();
    private final DefaultPublicationDao defaultPublicationDao = new DefaultPublicationDao(dbHelper);

    @Override
    public void init(ServletConfig config) throws ServletException {
        publicationService = new PublicationService(defaultPublicationDao, dbHelper);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/publications.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(Attributes.ID);
        publicationService.removePublication(id);
        resp.sendRedirect("/publications");
    }
}
