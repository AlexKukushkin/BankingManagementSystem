package services.admin_services;

import db.dao.AccountDAO;
import db.dao.ClientDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.Account;
import pojo.Client;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class AdminService {
    private static final Logger logger = Logger.getLogger(AdminService.class);

    public List<Client> doAdminGetAllClients() throws ServletException, IOException {
        List<Client> patients = null;
        try {
            patients = new ClientDAO().getAll();
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return patients;
    }

    public List<Account> doAdminGetAllAccounts() throws IOException, SQLException {
        List<Account> accounts = null;
        try {
            accounts = new AccountDAO().getAll();
        } catch (AccountDAO.AccountDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return accounts;
    }
}
