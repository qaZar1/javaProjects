package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MirrorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");

        // Проверка наличия параметра key
        if (key == null || key.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameter 'key'");
            return;
        }

        // Формирование ответа
        String content = "<html><body>\n" + key +  "</body></html>";

        // Отправка ответа
        resp.setContentType("text/html");
        resp.getWriter().println(content);
    }
}