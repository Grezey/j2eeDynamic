package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Hero;
import dao.HeroDAO;
@WebServlet(name = "HeroAddServlet",urlPatterns = "/addHero")
public class HeroAddServlet extends HeroListServlet{
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        req.setCharacterEncoding("UTF-8");
        Hero hero=new Hero();
        hero.setName(req.getParameter("name"));
        hero.setHp(Float.parseFloat(req.getParameter("hp")));
        hero.setDamage(Integer.parseInt(req.getParameter("damage")));
        new HeroDAO().add(hero);
        res.sendRedirect("/heroList");
    }
}
