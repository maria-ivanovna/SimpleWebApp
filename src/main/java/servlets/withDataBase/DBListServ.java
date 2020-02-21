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
import java.util.List;

@WebServlet("/DBList")
public class DBListServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBModel model = DBModel.getInstance();
        List<DBUser> list = model.select();
        req.setAttribute("users", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/DBjsp/DBUserList.jsp");
        dispatcher.forward(req, resp);
    }
}
