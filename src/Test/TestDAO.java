package Test;
import bean.Hero;
import dao.HeroDAO;
import java.util.List;

public class TestDAO {
    public static void main(String[] args){
        List<Hero> heros=new HeroDAO().list();
        for(Hero x:heros){
        System.out.printf("\n%d\n%s\n%f\n%d",x.getId(),x.getName(),x.getHp(),x.getDamage());
        }
    }
}
