import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User("login1", "password", "Monika", "M", "Wrocław", 1111));
        users.add(new User("login2", "password", "Monika2", "M2", "Wrocław", 2222));
    }

    public static List<User> getAllUsers(){
        return users;
    }

    public static void registerUser(User user){
        users.add(user);
    }
}
