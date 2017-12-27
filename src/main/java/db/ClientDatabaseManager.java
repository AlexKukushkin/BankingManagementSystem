package db;

import db.dao.ClientDAO;
import org.apache.log4j.Logger;
import pojo.Client;
import serialization.JAXBSerialization;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class ClientDatabaseManager {
    private static final Logger logger = Logger.getLogger(ClientDatabaseManager.class);

    public static void main(String[] args) {
        try {
            @XmlRootElement(name = "clients")
            @XmlAccessorType(XmlAccessType.FIELD)
            class Clients {
                @XmlElement(name = "clients")
                private List<Client> clients = null;

                public List<Client> getClients() {
                    return clients;
                }

                public void setClients(List<Client> clients) {
                    this.clients = clients;
                }
            }

            ClientDAO clientDAO = new ClientDAO();
            List<Client> clientList = clientDAO.getAll();
            Clients clients = new Clients();
            clients.setClients(clientList);
            JAXBSerialization.jaxbSerializeObject("ClientListXML.xml", clients);
//            clients = JAXBSerialization.jaxbDeSerializeObject("ClientListXML.xml", Clients.class);
//            clientDAO.insertAll(clients.getClients());
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}

