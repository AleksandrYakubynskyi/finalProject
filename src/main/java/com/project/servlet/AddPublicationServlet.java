package com.project.servlet;

import com.project.constant.Attributes;
import com.project.dao.impl.DefaultPublicationDao;
import com.project.entity.Publication;
import com.project.entity.enums.Topic;
import com.project.service.PublicationService;
import com.project.util.DbHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/addPublication")
public class AddPublicationServlet extends HttpServlet {
    private PublicationService publicationService;
    private final DbHelper dbHelper = new DbHelper();
    private final DefaultPublicationDao defaultPublicationDao = new DefaultPublicationDao(dbHelper);

    @Override
    public void init(ServletConfig config) throws ServletException {
        publicationService = new PublicationService(defaultPublicationDao, dbHelper);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addPublication.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String topic = req.getParameter(Attributes.TOPIC);
        String price = req.getParameter(Attributes.PRICE);
        String content = req.getParameter(Attributes.CONTENT);

        validateParameters(resp,req, topic, price, content);

        publicationService.addPublication(new Publication
                (Topic.valueOf(topic),BigDecimal.valueOf(Long.parseLong(price)),content));
        resp.sendRedirect("/addPublication.jsp");
    }

    private void validateParameters(HttpServletResponse resp, HttpServletRequest req, String... strings) throws IOException, ServletException {
        for (String string : strings) {
            if (string.isEmpty()) {
                String message = "Fill in all the fields!";
                req.setAttribute("errorMessage", message);
                resp.sendRedirect("/addPublication");
            }
        }
    }
}