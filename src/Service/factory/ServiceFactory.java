package Service.factory;

/**
 * 业务逻辑层的Factory
 */

import Service.impl.BookEBO;

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:Service.factory
 * @version：1.0
 */
public class ServiceFactory {
    public static BookEBO getBookEBO(){
        return new BookEBO();
    }
}
