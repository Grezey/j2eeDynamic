package how2java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 定义了java程序与数据库连接的静态方法
 */
public class DBhow2java {
    private static final String jdbcName="com.mysql.cj.jdbc.Driver";
    private static final String localUrl="jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String userName="root";
    private static final String userPassword="admin";

    /**
     * 驱动初始化
     */
    public DBhow2java(){}
    public static void getDriver(){
        try{
            Class.forName(jdbcName);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     * @return Connection
     * @throws SQLException 数据库异常
     */
    public static Connection getConnect() throws SQLException{
        getDriver();
        return DriverManager.getConnection(localUrl,userName,userPassword);
    }
    /**
     * 关闭连接
     * @param st Statement对象
     * @param con 数据库连接
     * @throws Exception 异常
     */
    public static void close(Statement st,Connection con) throws Exception{
        if(st!=null){
            st.close();
            if(con!=null) con.close();
        }
    }
    /**
     * 关闭连接
     * @param cst CallableStatement对象
     * @param con 数据库连接
     * @throws Exception 异常
     */
    public static void close(CallableStatement cst,Connection con) throws Exception{
        if(cst!=null){
            cst.close();
            if(con!=null) con.close();
        }
    }
    /**
     * 重载关闭方法
     * @param rs 结果集
     * @param pst PreparedStatement对象
     * @param con 数据库连接
     * @throws Exception 异常
     */
    public void close(ResultSet rs,PreparedStatement pst,Connection con) throws Exception{
        if(rs!=null){
            rs.close();
            if(pst!=null){
                pst.close();
                if(con!=null) con.close();
            }
        }
    }
}