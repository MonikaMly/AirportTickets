import Project.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/spr")
public class Checker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < Spr.getAllUsers().size(); i++) {
            resp.getWriter().write(String.valueOf(Spr.getAllUsers().get(i)));
        }
    }
}
