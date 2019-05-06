package by.vorokhobko.database;

import by.vorokhobko.model.Account;
import by.vorokhobko.model.User;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class DatabaseDAO {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseDAO.class);

    private final Properties prs = new Properties();
    /**
     * The class field.
     */
    private static Connection connection;

    private static final String INSERT_USER = "INSERT INTO user (name, superName) VALUES (?, ?)";

    private static final String UPDATE_USER = "UPDATE user SET name = ?, superUser = ? WHERE userId = ?";

    private static final String FIND_ALL_USERS = "SELECT * FROM user";

    private static final String DELETE_USER = "DELETE FROM user WHERE userId = ?";

    private static final String INSERT_ACCOUNT = "INSERT INTO account (account, userId) VALUES (?, ?)";

    private static final String UPDATE_ACCOUNT = "UPDATE account SET account = ?, userId = ? WHERE accountId = ?";

    private static final String FIND_ALL_ACCOUNTS = "SELECT * FROM account";

    private static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM user WHERE accountId = ?";

    private static final String DELETE_ACCOUNT = "DELETE FROM account WHERE userId = ?";
    /**
     * The method create connection with database.
     */
    public void createConnection() {
        try {
            connection = DriverManager.getConnection(this.prs.getProperty("url"),
                    this.prs.getProperty("username"), this.prs.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method create database.
     */
    public void createTable() {
        String sqlQuestionUser = "CREATE TABLE user("
                + "userId INTEGER,"
                + "name VARCHAR(45),"
                + "superName VARCHAR(45))";
        String sqlQuestionAccount = "CREATE TABLE account("
                + "userId INTEGER,"
                + "account INTEGER,"
                + "userId INTEGER REFERENCES user (userId))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuestionUser);
            statement.execute(sqlQuestionAccount);
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method adds a user to database.
     * @param user - user.
     */
    public void addUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSuperName());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method updates a user to database.
     * @param user - user.
     */
    public void updateUser(int id, User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSuperName());
            statement.setInt(3, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method searches all users.
     * @return tag.
     */
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
            try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User result = new User(
                        rs.getString("name"),
                        rs.getString("superUser")
                );
                result.setUserId(rs.getInt("userId"));
                list.add(result);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }
    /**
     * The method deletes duplicate.
     */
    public void removeItem(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNT)) {
            statement.setInt(1, id);
            connection.prepareStatement(DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method adds a user to database.
     * @param account - account.
     */
    public void addAccount(Account account) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_ACCOUNT)) {
            statement.setInt(1, account.getAccount());
            statement.setInt(2, account.getUserId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method updates a user to database.
     * @param account - account.
     */
    public void updateAccount(int id, Account account) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            statement.setInt(1, account.getAccount());
            statement.setInt(2, account.getUserId());
            statement.setInt(3, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method searches all users.
     * @return tag.
     */
    public List<Account> findAllAccounts() {
        List<Account> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_ACCOUNTS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account result = new Account(
                        rs.getInt("account"),
                        rs.getInt("userId")
                );
                result.setAccountId(rs.getInt("accountId"));
                list.add(result);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }
    /**
     * The method searches user.
     * @return tag.
     */
    public Account searchId(String id) {
        Account user = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_ACCOUNT_BY_ID)) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new Account(
                        Integer.parseInt(rs.getString("account")),
                        Integer.parseInt(rs.getString("userId"))
                );
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        if (user != null) {
            return user;
        } else {
            throw new NoSuchElementException("This user we don't have!");
        }
    }
    /**
     * The method close connection with database.
     */
    public void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}