package servlets.withDataBase;

import entities.withDataBase.DBUser;
import model.withDataBase.DBModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DBEdit")
public class DBEditServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("editId"));
            DBUser user = DBModel.getInstance().selectOne(id);
            if(user != null){
                req.setAttribute("username", user);
                getServletContext().getRequestDispatcher("jsp/jsp/DBjsp/DBEdit.jsp").forward(req,resp);
            }else {
                getServletContext().getRequestDispatcher("jsp/DBjsp/DBNotFound.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("jsp/DBjsp/DBNotFound.jsp").forward(req,resp);
            //System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("editId"));
            String name = req.getParameter("name");
            String pass = req.getParameter("pass");
            DBUser user = new DBUser(id, name, pass);
            DBModel.getInstance().update(user);
            resp.sendRedirect(req.getContextPath() + "/DBList");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("jsp/DBjsp/DBNotFound.jsp").forward(req,resp);
        }
    }
}
