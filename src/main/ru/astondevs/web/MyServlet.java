package main.ru.astondevs.web;

import main.ru.astondevs.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyServlet extends HttpServlet {
    private List<User> users;
    private final static String INDEX = "/WEB-INF/index.jsp";

    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();
        users.add(new User("Pikachu", "pikachu@yahoo.com"));
        users.add(new User("Cheburator", "Cheburator@mail.ru"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users);
        req.getRequestDispatcher(INDEX).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        final String name = req.getParameter("name");
        final String email = req.getParameter("email");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        User user = new User(name, email);
        users.add(user);
        doGet(req, resp);
    }

    private boolean requestIsValid(HttpServletRequest req) {
        final String name = req.getParameter("name");
        final String email = req.getParameter("email");
        return name != null && name.length() > 0 &&
                email != null && email.length() > 0;
    }
}
