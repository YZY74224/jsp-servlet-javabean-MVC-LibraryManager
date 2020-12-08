package Service.inter;

/**
 * 业务逻辑层的访问接口定义
 */

import Entity.BookBean.BookBean;

import java.io.StringReader;
import java.util.List;

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:Service.inter
 * @version：1.0
 */
public interface BookEBI {
    boolean create(BookBean bm);
    boolean delete(String Num);
    boolean update(BookBean bm);

    List<BookBean> findAll();
    BookBean findByNum(String Num);
}
