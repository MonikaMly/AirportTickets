import Project.DAO.UserDAO;

public class Checker {
    public static void main(String[] args) {

        System.out.println(UserDAO.isLoginDataValid("Monika","Monika"));
    }
}
