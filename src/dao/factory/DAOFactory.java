package dao.factory;

import dao.impl.BookDAO;

/**
 * 数据持久层的工厂
 */

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:dao.factory
 * @version：1.0
 */
public class DAOFactory {
    public static BookDAO getBookDAO(){
        return new BookDAO();
    }
}
