import Project.DAO.UserDAO;
import org.junit.Assert;
import org.junit.Test;

public class UserDAOTest {
    @Test
    public void isLoginValid(){
        Assert.assertEquals(UserDAO.isLoginDataValid("login","password"), true);
    }

}
