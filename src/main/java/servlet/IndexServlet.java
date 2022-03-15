package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", HbmStore.instOf().findAllItem());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getParameter("body");
        String mark = req.getParameter("mark");
        String engine = req.getParameter("engine");
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user);
        Item it = new Item(req.getParameter("description"), new Date(),
                                new  Car(new Mark(Integer.parseInt(mark)),
                                new Body(Integer.parseInt(body)),
                                new Engine(Integer.parseInt(engine))), user);
        HbmStore.instOf().addItem(it);
    }
}
