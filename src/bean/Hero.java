package bean;

/**
 * Hero类属性和数据库的表列名一一对应，实现数据库与java程序的交互
 */
public class Hero {
    private  int id;
    private String name;
    private float hp;
    private int damage;
    public Hero(){}
    public Hero(int id,String name,float hp,int damage){
        this.id=id;
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public float getHp() {
        return hp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + "]";
    }
}
