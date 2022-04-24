package servlet;

import model.*;
import store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class AdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String markS = req.getParameter("mark");
        Mark markId = HbmStore.instOf().findMarkId(Integer.parseInt(markS));
        String bodyS = req.getParameter("body");
        Body bodyId = HbmStore.instOf().findBodyId(Integer.parseInt(bodyS));
        System.out.println(bodyId.toString());
        String engineS = req.getParameter("engine");
        Engine engineId = HbmStore.instOf().findEngineId(Integer.parseInt(engineS));
        Car car = new Car();
        car.setMark(markId);
        car.setBody(bodyId);
        car.setEngine(engineId);
        car.setPrice(Integer.parseInt(req.getParameter("price")));
        Ads ads = new Ads();
        ads.setDescription(req.getParameter("description"));
        ads.setCreated(new Date());
        ads.setCar(car);
        HbmStore.instOf().addItem(ads);
        resp.sendRedirect(req.getContextPath() + "/index.do");
    }
}
