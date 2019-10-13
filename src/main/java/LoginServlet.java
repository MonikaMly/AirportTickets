import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        for (User user : UserDAO.getAllUsers()) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("login",login);
                    resp.sendRedirect("homepage.html");
                }
            } else {
                resp.getWriter().write("Wrong credencials");
            }
        }
    }
}
