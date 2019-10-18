public class Checker {
    public static void main(String[] args) {
        UserDAO.deleteById("Monika");
        System.out.println(UserDAO.isLoginDataValid("Monika","Monika"));
    }
}
