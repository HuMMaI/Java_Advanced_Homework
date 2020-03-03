package homework4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {
    private Connection connection;
    private final String SELECT_FROM_COUNTRIES = "SELECT * FROM countries";

    public List<Country> getAll() throws SQLException {
        connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_FROM_COUNTRIES);

        List<Country> countries = new ArrayList<>();

        while(resultSet.next()){
            countries.add(Country.of(resultSet));
        }

        return countries;
    }
}
