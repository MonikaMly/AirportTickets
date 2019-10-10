import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < UserDAO.getAllUsers().size(); i++) {
            resp.getWriter().write(String.valueOf(UserDAO.getAllUsers().get(i)));
            resp.getWriter().write("\r");
        }
    }
}
