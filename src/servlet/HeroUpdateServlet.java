package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeroUpdateServlet",urlPatterns = "/updateHero")
public class HeroUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //实例化Hero对象用来保存修改后的数据
        Hero hero = new Hero();
        hero.setId(Integer.parseInt(request.getParameter("id")));
        hero.setName(request.getParameter("name"));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));

        new HeroDAO().update(hero);
        //此时已完成更新操作，所以重定向回去的列表中显示的是及时更新的值
        response.sendRedirect("/listHero");
    }
}
