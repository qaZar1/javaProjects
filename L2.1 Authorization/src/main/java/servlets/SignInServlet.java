package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import accounts.AccountService;

public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("pass");

        // Проверка параметров
        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters 'login' or 'password'");
            return;
        }

        // Регистрация пользователя
        AccountService.getInstance().addUser(login, password);

        // Отправка ответа
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}