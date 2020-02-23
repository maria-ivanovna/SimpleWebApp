package servlets.withDataBase;

import entities.withDataBase.DBUser;
import model.withDataBase.DBModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DBAdd")
public class DBAddServ  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/DBjsp/DBAddUser.jsp");
          dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        if (!name.isEmpty() && !pass.isEmpty()){
            DBUser user = new DBUser(name, pass);
            DBModel model = DBModel.getInstance();
            model.insert(user);
        }
        req.setAttribute("username", name);
        doGet(req, resp);
    }
}
