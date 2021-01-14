package servlet;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeroDeleteServlet",urlPatterns = "/deleteHero")
public class HeroDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        int id=Integer.parseInt(req.getParameter("id"));
        new HeroDAO().delete(id);
        res.sendRedirect("/listHero");
    }
}