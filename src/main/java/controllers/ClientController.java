package controllers;

import db.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Client;
import services.client_services.ClientService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@Scope("session")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client_main", method = RequestMethod.GET)
    public String showClientMainPage() {
        return "client_main";
    }

    @RequestMapping(value = "/client_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request) {
        String exit = request.getParameter("exit");

        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "client_main";
        }
    }

    @RequestMapping(value = "/client_main/client_edit", method = RequestMethod.POST)
    public ModelAndView doEditClient(HttpServletRequest request) throws ClientDAO.ClientDAOException, UnsupportedEncodingException {

        ModelAndView modelAndView = new ModelAndView("client_edit");

        int userId = (Integer) request.getSession().getAttribute("userID");
        int clientId;
        Client client;

        clientId = clientService.getClientId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("clientID", clientId);

        client = clientService.getClientByID(clientId);
        modelAndView.getModel().put("client", client);

        return modelAndView;
    }

    @RequestMapping(value = "/client_main/client_info", method = RequestMethod.POST)
    public String showInfoPage() {
        return "client_info";
    }

    @RequestMapping(value = "/client_main/client_save", method = RequestMethod.POST)
    public String saveClients(HttpServletRequest request) throws UnsupportedEncodingException {
        //@RequestParam(name = "first_name") String firstName
        int idClient = Integer.valueOf(request.getParameter("id_client"));
        String firstName = request.getParameter("first_name");
        String familyName = request.getParameter("family_name");
        String patronymic = request.getParameter("patronymic");
        String birthDate = request.getParameter("birth_date");
        String passport = request.getParameter("passport");
        String registerLocation = request.getParameter("registration");
        String homeLocation = request.getParameter("home_location");
        String sexType = request.getParameter("sextype");
        String phoneNumber = request.getParameter("phone_number");
        int idUser = Integer.valueOf(request.getParameter("user_id"));

        clientService.saveClient(idClient, firstName, familyName, patronymic, birthDate, passport,
          registerLocation, homeLocation, sexType, phoneNumber, idUser);

        return "redirect:/client_main/client_data";
    }

    @RequestMapping(value = "/client_main/client_data", method = RequestMethod.GET)
    public ModelAndView getClients(HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("client_data");
        List<Client> clients;

        clients = clientService.getClients();
        modelAndView.getModel().put("list", clients);

        return modelAndView;
    }
}
