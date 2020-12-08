package dao.inter;
import Entity.BookBean.BookBean;

import java.util.List;

/**
 * 数据持久层的接口层，负责定义实现方法的接口
 */

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:dao.inter
 * @version：1.0
 */
public interface IBaseDAO {

    boolean create(BookBean bm);//定义新增图书的接口
    boolean delete(String Num);//定义删除图书的接口
    boolean update(BookBean bm);//定义修改图书的接口

    List<BookBean> findAll();   //定义查找所有图书的接口
    BookBean findByNum(String Num);//定义根据主键图书编号来查找图书的接口
}
