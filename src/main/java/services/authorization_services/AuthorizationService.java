package services.authorization_services;

import pojo.User;

public interface AuthorizationService {
    User auth(String login, String password);
    int getUserID(String login, String password);
}
