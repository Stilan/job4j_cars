package servlet;

import model.User;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (HbmStore.instOf().findByNameUser(name, email, password) == null) {
            User user =  HbmStore.instOf().addUser(new User(name, email, password));
            HttpSession sc = req.getSession();
            sc.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            req.setAttribute("error", "Пользавател уже существует");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
    }
}
