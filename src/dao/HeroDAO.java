package dao;
import bean.Hero;
import how2java.DBhow2java;

import java.sql.*;
import java.util.*;

/**
 * DAO接口的实现类
 * 可以看作是数据库在java程序中的实例化，将SQL语句转化成java方法
 */
public class HeroDAO implements DAO<Hero>{
    public HeroDAO(){}
    /**
     * 该方法返回数据行总行数
     * @return total
     */
    public int getTotal() {
        int total = 0;
        try (Connection con = DBhow2java.getConnect();
             Statement st = con.createStatement()) {
            String sql = "select count(*) from hero";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.printf("表Hero共有%d行", total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    /**
     * 该方法定义HeroDAO类的add操作，并返回操作影响数据行总数
     * @param hero 待添加Hero对象
     * @return inf
     */
    public int add(Hero hero){
        String sql="insert into hero values (null,?,?,?)";
        int inf=0;
        try(Connection con=DBhow2java.getConnect();
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,hero.getName());
            ps.setFloat(2,hero.getHp());
            ps.setInt(3,hero.getDamage());
            inf=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                int id=rs.getInt(1);
                hero.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return inf;
    }

    /**
     * 该方法定义HeroDAO类的删除操作，返回受影响的行数
     * @param id 待删除Hero对象id
     * @return inf
     */
    public int delete(int id){
        String sql="delete from hero where id="+id;
        int inf=0;
        try(Connection con=DBhow2java.getConnect();
            Statement st=con.createStatement()){
            inf=st.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return inf;
    }

    /**
     * 该方法定义HeroDAO类的更新操作，返回受影响的行数
     * @param hero 待更新Hero对象
     * @return inf
     */
    public int update(Hero hero){
        String sql="update hero set name=?, hp=?, damage=? where id=?";
        int inf=0;
        try(Connection con=DBhow2java.getConnect();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1, hero.getName());
            ps.setFloat(2,hero.getHp());
            ps.setInt(3,hero.getDamage());
            ps.setInt(4,hero.getId());
            inf=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return inf;
    }

    /**
     * 该方法定义HeroDAO类的取元素操作，并返回一个Hero对象
     * @param id 查询元素id
     * @return hero
     */
    public Hero get(int id){
        Hero hero=null;
        try(Connection con=DBhow2java.getConnect();
            Statement st=con.createStatement()){
            String sql="select * from hero where id="+id;
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                hero=new Hero();
                String name=rs.getString("name");
                float hp=rs.getFloat("hp");
                int damage=rs.getInt("damage");
                hero.setName(name);
                hero.setHp(hp);
                hero.setDamage(damage);
                hero.setId(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

    /**
     * 该方法定义HeroDAO类的分页查询操作，以列表形式返回从start起始count个元素的查询结果
     * @param start 起始位置
     * @param count 查询元素总数
     * @return list
     */
    public List<Hero> list(int start,int count){
        List<Hero> heros=new ArrayList<>();
        String sql="select * from hero order by id limit ? offset ?";
        try(Connection con=DBhow2java.getConnect();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,count);
            ps.setInt(2,start);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Hero hero=new Hero();
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getFloat(3));
                hero.setDamage(rs.getInt(4));
                heros.add(hero);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heros;
    }

    /**
     *该方法返回HeroDAO类的查询操作，以列表形式返回表中所有元素的查询结果
     * @return list
     */
    public List<Hero> list(){
        return list(0,Short.MAX_VALUE);
    }
}