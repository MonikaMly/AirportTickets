package Project.DAO;

import Project.Config.DBConnection;
import Project.Model.User;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class UserDAO {

    public static List<User> getAllUsers() {
        Connection connection = DBConnection.createConnection();
        List<User> userList = new ArrayList<>();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM user;");

            while (rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String city = rs.getString("city");
                int year = rs.getInt("birthYear");

                User user = new User(login,password,name,surname,city,year);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User getUserByLogin(String login) {

        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user where login = ?;");

            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String city = rs.getString("city");
                int year = rs.getInt("birthYear");

                User user = new User(login,password,name,surname,city,year);

                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void registerUser(User user) {
        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?);");

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
            ps.setString(5, user.getCity());
            ps.setInt(6, user.getBirthYear());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateUser(User user) {
        Connection connection = DBConnection.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET password = ?, name = ?, surname = ?, city = ?, birthYear = ? WHERE login = ?;");
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getCity());
            ps.setInt(5, user.getBirthYear());
            ps.setString(6, user.getLogin());

            ps.executeUpdate();
        } catch (Exception e){
        }

    }

        public static void deleteById(String login) {
            Connection connection = DBConnection.createConnection();
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE login = ?;");
                ps.setString(1, login);
                ps.executeUpdate();
            } catch (Exception e){
            }

        }

    public static boolean isLoginDataValid(String login, String password) {
        Connection connection = DBConnection.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?;");
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
        }

        return false;

    }

}
