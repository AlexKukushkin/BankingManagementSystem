package servlets.client_servlets;

import services.client_services.ClientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientSaveServlet extends HttpServlet{
    ClientService clientService = new ClientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        int idClient = Integer.valueOf(req.getParameter("id_client"));
        String firstName = req.getParameter("first_name");
        String familyName = req.getParameter("family_name");
        String patronymic = req.getParameter("patronymic");
        String birthDate = req.getParameter("birth_date");
        String passport = req.getParameter("passport");
        String registerLocation = req.getParameter("registration");
        String homeLocation = req.getParameter("home_location");
        String sexType = req.getParameter("sextype");
        String phoneNumber = req.getParameter("phone_number");
        int idUser = Integer.valueOf(req.getParameter("user_id"));

        clientService.saveClient(idClient, firstName, familyName, patronymic, birthDate, passport,
                registerLocation, homeLocation, sexType, phoneNumber, idUser);
        resp.sendRedirect(String.format("/web/client_main/client_data"));
    }
}
