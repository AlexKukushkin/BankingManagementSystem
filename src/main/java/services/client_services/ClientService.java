package services.client_services;

import db.dao.ClientDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.Client;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private static final Logger logger = Logger.getLogger(ClientService.class);
    private static ClientDAO clientDAO = new ClientDAO();
    
    public List<Client> getClients(){
        List<Client> clients = new ArrayList<>();
        try {
            clients = new ClientDAO().getAll();
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return clients;
    }

    public int getClientId(int userId) throws ClientDAO.ClientDAOException {
        int clientId;

        clientId = clientDAO.getClientID(Integer.valueOf(userId));

        return clientId;
    }

    public Client getClientByID(int clientId){
        Client client = new Client();

        try {
            client = clientDAO.getByID(clientId);
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return client;
    }

    public void saveClient(int idClient, String firstName, String familyName, String patronymic,
                            String birthDate, String passport, String registerLocation,
                           String homeLocation, String sexType, String phoneNumber, int idUser){
        try {
            clientDAO.update(new Client(idClient, firstName, familyName, patronymic, birthDate,
                    passport, registerLocation, homeLocation, sexType, phoneNumber, idUser));
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
