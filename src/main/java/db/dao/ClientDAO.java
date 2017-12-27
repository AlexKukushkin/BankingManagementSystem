package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import pojo.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDAO implements IAbstractDAO<Client> {
    public static class ClientDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(ClientDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<Client> getAll() throws ClientDAOException {
        List<Client> clientList = new ArrayList<>();
        logger.info("Log for getAll Clients");

        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("id_client"),
                        resultSet.getString("first_name"),
                        resultSet.getString("family_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("passport"),
                        resultSet.getString("registration"),
                        resultSet.getString("home_location"),
                        resultSet.getString("sextype"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("user_id"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
        return clientList;
    }

    @Override
    public Client getByID(int id) throws ClientDAOException {

        logger.info("Log for get Client by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM client WHERE id_сlient = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Client(
                    resultSet.getInt("id_client"),
                    resultSet.getString("first_name"),
                    resultSet.getString("family_name"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("passport"),
                    resultSet.getString("registration"),
                    resultSet.getString("home_location"),
                    resultSet.getString("sextype"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("user_id"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }

    public int getClientID(int id_user) throws ClientDAOException {

        logger.info("Log for get Client by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT cl.id_сlient FROM сlient cl JOIN users usr " +
                    "ON cl.user_id = usr.id_user AND usr.id_user = ?");
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id_сlient");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE сlient SET first_name = ?, family_name = ?, patronymic = ?, birth_date = ?, " +
                        "passport = ?, registration = ?, \"home_location\" = ?, sextype = ?, \"phone_number\" = ? " +
                        "WHERE id_сlient = ?");
    }

    @Override
    public void update(Client client) throws ClientDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getFamilyName());
            statement.setString(3, client.getPatronymic());
            statement.setDate(4, Date.valueOf(client.getBirthDate()));
            statement.setString(5, client.getPassport());
            statement.setString(6, client.getRegisterLocation());
            statement.setString(7, client.getAddress());
            statement.setString(8, client.getSexType());
            statement.setString(9, client.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }

    @Override
    public void updateAll(List<Client> clientList) throws ClientDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            for (Client client : clientList) {
                statement.setInt(1, client.getIdClient());
                statement.setString(2, client.getFirstName());
                statement.setString(3, client.getFamilyName());
                statement.setString(4, client.getPatronymic());
                statement.setDate(5, Date.valueOf(client.getBirthDate()));
                statement.setString(6, client.getPassport());
                statement.setString(7, client.getRegisterLocation());
                statement.setString(8, client.getAddress());
                statement.setString(9, client.getSexType());
                statement.setInt(10, client.getIdUser());
                statement.setString(11, client.getPhoneNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws ClientDAOException {

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE сlient WHERE id_сlient = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "INSERT INTO сlient(first_name, family_name, patronymic, birth_date," +
                        " passport, registration, home_location, sextype, user_id, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Client client) throws ClientDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getFamilyName());
            statement.setString(3, client.getPatronymic());
            statement.setDate(4, Date.valueOf(client.getBirthDate()));
            statement.setString(5, client.getPassport());
            statement.setString(6, client.getRegisterLocation());
            statement.setString(7, client.getAddress());
            statement.setString(8, client.getSexType());
            statement.setInt(9, client.getIdUser());
            statement.setString(10, client.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }

    }

    @Override
    public void insertAll(List<Client> clientList) throws ClientDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            for (Client client : clientList) {
                statement.setString(1, client.getFirstName());
                statement.setString(2, client.getFamilyName());
                statement.setString(3, client.getPatronymic());
                statement.setDate(4, Date.valueOf(client.getBirthDate()));
                statement.setString(5, client.getPassport());
                statement.setString(6, client.getRegisterLocation());
                statement.setString(7, client.getAddress());
                statement.setString(8, client.getSexType());
                statement.setInt(9, client.getIdUser());
                statement.setString(10, client.getPhoneNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new ClientDAOException();
        }
    }
}
