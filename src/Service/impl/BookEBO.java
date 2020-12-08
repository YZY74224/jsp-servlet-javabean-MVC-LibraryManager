package Service.impl;


/**
 * 业务层逻辑的接口实现通过
 * 调用数据持久层中的接口以及
 * 其实现的方法来实现功能
 */

import Entity.BookBean.BookBean;
import Service.inter.BookEBI;
import dao.factory.DAOFactory;
import dao.inter.IBaseDAO;

import javax.swing.*;
import java.util.List;

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:Service.impl
 * @version：1.0
 */
public class BookEBO implements BookEBI {

    @Override
    public boolean create(BookBean bm) {
        IBaseDAO baseDAO = DAOFactory.getBookDAO();
        return baseDAO.create(bm);
    }

    @Override
    public boolean delete(String Num) {
        IBaseDAO baseDAO = DAOFactory.getBookDAO();
        return baseDAO.delete(Num);
    }

    @Override
    public boolean update(BookBean bm) {
        IBaseDAO baseDAO = DAOFactory.getBookDAO();
        return baseDAO.update(bm);
    }

    @Override
    public List<BookBean> findAll() {
        IBaseDAO baseDAO = DAOFactory.getBookDAO();
        List <BookBean> list = baseDAO.findAll();
        return list;
    }

    @Override
    public BookBean findByNum(String Num) {
        IBaseDAO baseDAO = DAOFactory.getBookDAO();
        BookBean bm = baseDAO.findByNum(Num);
        return bm;
    }
}
