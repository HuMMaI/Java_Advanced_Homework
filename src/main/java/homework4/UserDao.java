package homework4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection;
    private final String SELECT_FROM_USERS = "SELECT * FROM users";
    private final String SELECT_FROM_USERS_WHERE_ID = "SELECT * FROM users WHERE id=";
    private final String INSERT_INTO_USERS =
            "INSERT INTO users(first_name, last_name, age, country_id) VALUES (?, ?, ?, ?)";
    private final String DELETE_FROM_USERS_WHERE_ID = "DELETE FROM users WHERE id=";

    public List<User> getAll() throws SQLException {
        connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_USERS);

        List<User> users = new ArrayList<>();

        while(resultSet.next()){
            users.add(User.of(resultSet));
        }

        statement.close();
        resultSet.close();
        connection.close();

        return users;
    }

    public User getById(int id) throws SQLException {
        connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_USERS_WHERE_ID + id);

        resultSet.next();
        User user = User.of(resultSet);

        statement.close();
        resultSet.close();
        connection.close();

        return user;
    }

    public int insert(String firstName, String lastName, int age, int countryId) throws SQLException {
        connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, age);
        preparedStatement.setInt(4, countryId);

        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        
        int id = generatedKeys.getInt(1);

        preparedStatement.close();
        generatedKeys.close();
        connection.close();

        return id;
    }
    
    public void deleteById(int id) throws SQLException {
        connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(DELETE_FROM_USERS_WHERE_ID + id);

        statement.close();
        connection.close();
    }
}
