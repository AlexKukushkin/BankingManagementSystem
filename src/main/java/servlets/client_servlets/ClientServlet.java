package servlets.client_servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client_main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exit = req.getParameter("exit");

        if ("exit".equals(exit)) {
            req.getSession().setAttribute("isAuth", false);
            req.getSession().setAttribute("role", null);
            resp.sendRedirect("/web");
        } else {
            resp.sendRedirect("/web/client_main");
        }
    }
}
