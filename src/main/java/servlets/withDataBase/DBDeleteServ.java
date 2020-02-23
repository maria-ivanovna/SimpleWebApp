package servlets.withDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DBDelete")
public class DBDeleteServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("editId"));
            resp.sendRedirect(req.getContextPath() + "/DBList");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("jsp/DBjsp/DBNotFound.jsp").forward(req,resp);
        }
    }
}
