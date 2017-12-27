package services.registration_services;

import db.dao.IUserDAO;
import db.dao.ClientDAO;
import dto.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pojo.Client;
import pojo.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
    private IUserDAO userDAO;
    private ClientDAO clientDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(IUserDAO userDAO, ClientDAO clientDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.clientDAO = clientDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Boolean regUser(String login, String password) {
        if (login == null || password == null) {
            return false;
        }else{
            userDAO.createUser(new User(login, passwordEncoder.encode(password), "client"));
        }
        return true;
    }

    @Override
    public int getUserID(String login, String password) {
        if(login == null || password == null){
            return 0;
        }
        return userDAO.getUserId(login, passwordEncoder.encode(password));
    }

    @Override
    public void insertUser(String login, String password, UserDTO userDTO) {
        try {
            int idUser = getUserID(login, password);
            clientDAO.insertOne(new Client(userDTO.getFirstName(), userDTO.getFamilyName(), userDTO.getPatronymic(),
                    userDTO.getBirthDate(), userDTO.getPassport(),
                    userDTO.getRegisterLocation(), userDTO.getAddress(),
                    userDTO.getSexType(), userDTO.getPhoneNumber()));
        } catch (ClientDAO.ClientDAOException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
