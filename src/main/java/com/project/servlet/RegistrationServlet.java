package com.project.servlet;

import com.project.constant.Attributes;
import com.project.dao.impl.DefaultUserDao;
import com.project.entity.User;
import com.project.entity.enums.Gender;
import com.project.service.UserService;
import com.project.util.DbHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserService userService;
    private final DbHelper dbHelper = new DbHelper();
    private final DefaultUserDao defaultUserDao = new DefaultUserDao(dbHelper);

    @Override
    public void init() throws ServletException {
        userService = new UserService(dbHelper, defaultUserDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstname = req.getParameter(Attributes.FIRSTNAME);
        String lastname = req.getParameter(Attributes.LASTNAME);
        String email = req.getParameter(Attributes.EMAIL);
        String password = req.getParameter(Attributes.PASSWORD);
        String gender = req.getParameter(Attributes.GENDER);

        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()) {
            String message = "User with this email address already exists!";
            req.setAttribute("errorMessage", message);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
            return;
        }
        validateParameters(resp, firstname, lastname, email, password, gender);
        userService.addUser(new User(firstname, lastname, email, password, Gender.valueOf(gender)));
        resp.sendRedirect("/");
    }

    private void validateParameters(HttpServletResponse resp, String... strings) throws IOException {
        for (String string : strings) {
            if (string.isEmpty()) {
                resp.sendRedirect("/registration");
            }
        }
    }
}



