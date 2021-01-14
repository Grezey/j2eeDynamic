package dao;
import java.util.List;

/**
 * CRUD等操作的接口定义
 * @param <T>
 */
public interface DAO<T>{
    /**
     * 增加
     */
    int add(T t);
    /**
     * 删除
     */
    int delete(int id);
    /**
     * 修改
     */
    int update(T t);
    /**
     * 获取
     */
    T get(int id);
    /**
     * 返回表中行总数
     */
    int getTotal();
    /**
     * 查询
     */
    List<T> list();
    /**
     * 分页查询
     */
    List<T> list(int start,int count);
}
