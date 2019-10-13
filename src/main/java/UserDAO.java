import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<User>();

    static{
        users.add(new User("login1", "password", "Monika", "M", "Wrocław", 1111));
        users.add(new User("login2", "password", "Monika2", "M2", "Wrocław", 2222));
    }

    public static List<User> getAllUsers(){
        Connection connection = DBConnection.createConnection();
        List<User> allUsers = new ArrayList<User>();

        try{
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM user;");

            while (rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String city = rs.getString("city");
                int birthYear = rs.getInt("birthYear");

                User user = new User(login,password,name,surname,city,birthYear);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public User getUserByLogin(String login){
        Connection connection = DBConnection.createConnection();

        try {
            {
                PreparedStatement ps = connection.prepareStatement("SELECT  * FROM user where id = ?;");
                ps.setString(1,login);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    String password = rs.getString("password");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String city = rs.getString("city");
                    int birthYear = rs.getInt("birthYear");

                    User user = new User(login,password,name,surname,city,birthYear);

                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void registerUser(User user){
        users.add(user);
    }
}
