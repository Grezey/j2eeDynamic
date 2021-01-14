package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "HeroListServlet",urlPatterns = "/listHero")
public class HeroListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int start=0;
        int count=5;

        //该try块用于接收每次从请求处传来的start值
        try{
            start=Integer.parseInt(request.getParameter("start"));
        }catch (NumberFormatException e){
            //当浏览器没有传入start参数时
            e.printStackTrace();
        }

        int next=start+count;
        int pre=start-count;
        int total=new HeroDAO().getTotal();
        int last;
        //这里注意limit子句导致的查询结果开始id=start+1,即start=0，则从id=1（第一行）开始
        if(0==total%count) last=total-count;
        else last=total-total%count;

        //边界处理，注意pre<0和next>last的情况
        pre=pre<0 ? 0 : pre;
        next=next>last ? last : next;

        request.setAttribute("next",next);
        request.setAttribute("pre",pre);
        request.setAttribute("last",last);

        List<Hero> heros=new HeroDAO().list(start,count);
        //将从数据库取出的heros集合保存在当前session中
        request.setAttribute("heros",heros);

        //server内转发
        request.getRequestDispatcher("listHero.jsp").forward(request,response);
    }
}