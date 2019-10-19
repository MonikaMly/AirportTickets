package Project.Servlet;

import Project.Model.User;
import Project.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String birthYear = req.getParameter("birthYear");
        int year = Integer.parseInt(birthYear);
        String type = req.getParameter("type");

        if (type.equals("add")) {
            User newUser = new User(login, password, name, surname, city, year);
            UserDAO.registerUser(newUser);
            resp.sendRedirect("login.html");
        } else if (type.equals("update")){
            User newUser = new User(login, password, name, surname, city, year);
            UserDAO.updateUser(newUser);
            resp.sendRedirect("userslist.jsp");
        }
    }
}
