package com.project.servlet;

import com.project.constant.Attributes;
import com.project.dao.impl.DefaultUserDao;
import com.project.entity.User;
import com.project.service.UserService;
import com.project.util.DbHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService;
    private final DbHelper dbHelper = new DbHelper();
    private final DefaultUserDao defaultUserDao = new DefaultUserDao(dbHelper);

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        new UserService(dbHelper, defaultUserDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(Attributes.EMAIL);
        String password = req.getParameter(Attributes.PASSWORD);

        Optional<User> user = userService.getUserByEmail(email);

        if (!user.isPresent()) {
            String message = "User with this email address does not exist";
            req.setAttribute("message", message);
            resp.sendRedirect("/login");
        }

        if (!Objects.equals(password, user.get().getPassword())) {
            String message = "Invalid password";
            req.setAttribute("message", message);
            resp.sendRedirect("/login");
        }
        HttpSession session = req.getSession();
        session.setAttribute(Attributes.USER, user);
    }
}

