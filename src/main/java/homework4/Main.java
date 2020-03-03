package homework4;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CountryDao countryDao = new CountryDao();

        try {
            System.out.println(userDao.getAll());
            System.out.println(countryDao.getAll());
            System.out.println(userDao.getById(2));
            System.out.println("Generated id = "
                    + userDao.insert("NewFirstName", "NewLastName", 20, 2));
            System.out.println(userDao.getAll());
            userDao.deleteById(1);
            System.out.println(userDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
