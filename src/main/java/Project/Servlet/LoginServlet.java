package Project.Servlet;

import Project.DAO.UserDAO;

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


        if (UserDAO.isLoginDataValid(login,password)) {
            req.getSession().setAttribute("username", login);

            resp.sendRedirect(resp.encodeRedirectURL("homepage.html"));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login.html"));
        }
    }
    }

