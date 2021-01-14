package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HeroEditServlet",urlPatterns = "/editHero")
public class HeroEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HeroDAO dao=new HeroDAO();
        Hero hero=dao.get(id);
        StringBuffer format = new StringBuffer();
        response.setContentType("text/html; charset=UTF-8");

        //调用java变量来显示表单内的指定id对象值，否则<form>标签要求用户提交表单信息，写成html文件的话没办法直接调用java变量会抛出异常
        format.append("<!DOCTYPE html>");
        format.append("<form action='updateHero' method='post'>");
        format.append("名字 ： <input type='text' name='name' value='%s' > <br>");
        format.append("血量 ： <input type='text' name='hp'  value='%f' > <br>");
        format.append("伤害： <input type='text' name='damage'  value='%d' > <br>");
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");
        String html = String.format(format.toString(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId());
        response.getWriter().write(html);
    }
}