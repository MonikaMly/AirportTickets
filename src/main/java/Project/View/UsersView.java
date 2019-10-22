package Project.View;

import Project.DAO.UserDAO;
import Project.Model.User;
import Project.Service.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userslist")
public class UsersView extends HttpServlet {
    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userService.getAllUsers();

        req.setAttribute("usersList", allUsers);
        req.getRequestDispatcher("/userslist.jsp").forward(req, resp);

    }

}
