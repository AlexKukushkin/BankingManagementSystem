package db.dao;

import db.IConnectionManager;
import db.TomcatConnectionPool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import pojo.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO implements IAbstractDAO<Account> {
    public static class AccountDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(ClientDAO.class);

    static {
        manager = TomcatConnectionPool.getInstance();
    }

    @Override
    public List<Account> getAll() throws AccountDAOException {
        List<Account> accountList = new ArrayList<>();
        logger.info("Log for getAll Clients");

        try (Connection connection = manager.getConnection()){
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt("id_account"),
                        resultSet.getString("account_number"),
                        resultSet.getInt("balance"),
                        resultSet.getInt("credit"),
                        resultSet.getInt("debet"),
                        resultSet.getInt("client_id"));
                accountList.add(account);
            }
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
        return accountList;
    }

    @Override
    public Account getByID(int id) throws AccountDAOException {

        logger.info("Log for get Client by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account WHERE id_account = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Account(
                    resultSet.getInt("id_account"),
                    resultSet.getString("account_number"),
                    resultSet.getInt("balance"),
                    resultSet.getInt("credit"),
                    resultSet.getInt("debet"),
                    resultSet.getInt("client_id"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }

    public int getAccountID(int id_client) throws AccountDAOException {

        logger.info("Log for get Client by ID");

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT ac.id_account FROM account ac JOIN client cl " +
                    "ON cl.id_client = ac.client_id AND cl.id_client = ?");
            statement.setInt(1, id_client);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id_account");
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "UPDATE account SET balance = ?, credit = ?, debet = ?, client_id = ?, " +
                        "\"account_number\" = ? " +
                        "WHERE id_account = ?");
    }

    @Override
    public void update(Account account) throws AccountDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            statement.setInt(1, account.getBalance());
            statement.setInt(2, account.getCredit());
            statement.setInt(3, account.getDebet());
            statement.setInt(4, account.getIdClient());
            statement.setString(5, account.getAccountNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }

    @Override
    public void updateAll(List<Account> accountList) throws AccountDAOException {

        try {
            PreparedStatement statement = getUpdateStatement();
            for (Account account : accountList) {
                statement.setInt(1, account.getBalance());
                statement.setInt(2, account.getCredit());
                statement.setInt(3, account.getDebet());
                statement.setInt(4, account.getIdClient());
                statement.setString(5, account.getAccountNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws AccountDAOException {

        try (Connection connection = manager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE account WHERE id_account = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = manager.getConnection();
        return connection.prepareStatement(
                "INSERT INTO account(balance, credit, debet, client_id," +
                        " account_number) VALUES (?, ?, ?, ?, ?)");
    }

    @Override
    public void insertOne(Account account) throws AccountDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            statement.setInt(1, account.getBalance());
            statement.setInt(2, account.getCredit());
            statement.setInt(3, account.getDebet());
            statement.setInt(4, account.getIdClient());
            statement.setString(5, account.getAccountNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }

    }

    @Override
    public void insertAll(List<Account> accountList) throws AccountDAOException {

        try {
            PreparedStatement statement = getInsertStatement();
            for (Account account : accountList) {
                statement.setInt(1, account.getBalance());
                statement.setInt(2, account.getCredit());
                statement.setInt(3, account.getDebet());
                statement.setInt(4, account.getIdClient());
                statement.setString(5, account.getAccountNumber());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new AccountDAOException();
        }
    }
}
