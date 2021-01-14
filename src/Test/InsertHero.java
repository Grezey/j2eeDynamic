package Test;
import bean.Hero;
import dao.HeroDAO;
public class InsertHero {
    public static void main(String[] args){
        Hero hero=new Hero();
        HeroDAO dao=new HeroDAO();
        for(int i=0;i<40;i++){
            hero.setId(i+10);
            hero.setName("a"+i);
            hero.setHp(1000+i);
            hero.setDamage(40+i);
            dao.add(hero);
        }
    }
}
