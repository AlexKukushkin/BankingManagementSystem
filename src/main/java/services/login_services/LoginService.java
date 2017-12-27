package services.login_services;

import db.dao.ClientDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.User;
import services.authorization_services.AuthorizationServiceImpl;
import servlets.authorization_servlets.AuthServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
public class LoginService {
    private static final Logger logger = Logger.getLogger(AuthServlet.class);
    AuthorizationServiceImpl authorizationService;
    ClientDAO clientDAO;

    public LoginService(AuthorizationServiceImpl authorizationService, ClientDAO clientDAO) {
        this.authorizationService = authorizationService;
        this.clientDAO = clientDAO;
    }

    public String sortUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession currentSession = request.getSession();
        Boolean isAuth = (Boolean) currentSession.getAttribute("isAuth");

        String role;
        int userId;

        if (isAuth == null) {
            isAuth = false;
        }

        if (isAuth) {
            role = (String) currentSession.getAttribute("role");
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            User user = authorizationService.auth(login, password);
            role = user.getRole();

            userId = authorizationService.getUserID(login, password);
            currentSession.setAttribute("userID", userId);

            try {
                int clientId = clientDAO.getClientID(Integer.valueOf(userId));
                currentSession.setAttribute("clientID", clientId);
            } catch (ClientDAO.ClientDAOException e) {
                logger.error("This is Error : " + e.getMessage());
            }
        }

        if (!"false".equals(role)){
            currentSession.setAttribute("isAuth", true);
            currentSession.setAttribute("role", role);
            switch (role) {
                case "admin":
                    return "redirect:/admin_main";
                case "client":
                    return "redirect:/client_main";
                default:
                    return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
    }
}
