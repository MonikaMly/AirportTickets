package Project.DAO;

import Project.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User("Monika", "Monika", "Monika", "Monika", "Wrocław", 1234));
        users.add(new User("Monika2", "Monika", "Monika", "Monika", "Wrocław", 5678));
        users.add(new User("Monika3", "Monika", "Monika", "Monika", "Wrocław", 4321));
        users.add(new User("Monika4", "Monika", "Monika", "Monika", "Wrocław", 8765));
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static User getUserByLogin(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                return users.get(i);
            }
        }
        return null;
    }

    public static void registerUser(User user) {
        users.add(user);
    }

    public static void updateUser(User user) {
        UserDAO.getUserByLogin(user.getLogin()).setPassword(user.getPassword());
        UserDAO.getUserByLogin(user.getLogin()).setName(user.getName());
        UserDAO.getUserByLogin(user.getLogin()).setSurname(user.getSurname());
        UserDAO.getUserByLogin(user.getLogin()).setCity(user.getCity());
        UserDAO.getUserByLogin(user.getLogin()).setBirthYear(user.getBirthYear());
        }

        public static void deleteById(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                users.remove(users.get(i));
            }
        }
    }

    public static boolean isLoginDataValid(String login, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
