package Project.Service;

import Project.DAO.UserDAO;
import Project.Model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService {
    @EJB
    UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void deleteById(String login) {
        userDAO.deleteById(login);
    }

    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public boolean isLoginDataValid (String login, String password){
        return userDAO.isLoginDataValid(login,password);
    }
}