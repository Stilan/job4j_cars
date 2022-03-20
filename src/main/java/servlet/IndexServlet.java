package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        List list = HbmStore.instOf().findAllItem();
        System.out.println(list.toString());
        String json = GSON.toJson(HbmStore.instOf().findAllItem());
        System.out.println(json);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getParameter("body");
        String mark = req.getParameter("mark");
        String engine = req.getParameter("engine");
        User user = (User) req.getSession().getAttribute("user");
        Ads it = new Ads(req.getParameter("description"), new Date(),
                                new  Car(new Mark(Integer.parseInt(mark)),
                                new Body(Integer.parseInt(body)),
                                new Engine(Integer.parseInt(engine)),
                                        Integer.parseInt(req.getParameter("prise")), user));
        HbmStore.instOf().addItem(it);
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
