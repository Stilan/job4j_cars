package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import store.AdRepository;
import store.MarkRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MarkServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(MarkRepository.instOf().findAllMark());
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }

}
