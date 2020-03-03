package homework4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Country {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Country of(ResultSet resultSet){
        Country country = new Country();

        try {
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t create country!");
        }

        return country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
