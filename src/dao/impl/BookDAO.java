package dao.impl;

/**
 * 实现在数据持久层接口部分定义的方法
 */

import Common.druid.DBConnect;
import Entity.BookBean.BookBean;
import dao.inter.IBaseDAO;

import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:dao.impl
 * @version：1.0
 */
public class BookDAO implements IBaseDAO {

    //新增方法
    @Override
    public boolean create(BookBean bm) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "INSERT INTO jwex3.图书信息表 VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //设置占位符
            pstmt.setString(1, bm.getNum());
            pstmt.setString(2, bm.getName());
            pstmt.setString(3, bm.getPrice());
            pstmt.setString(4, bm.getPublisher());

            //执行SQL语句
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(pstmt, conn);
        }
        return true;
    }

    //删除方法
    @Override
    public boolean delete(String Num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "delete from jwex3.图书信息表 where Num = ?";
            pstmt = conn.prepareStatement(sql);
            //设置占位符
            pstmt.setString(1, Num);
            //执行SQL语句
            pstmt.execute();
        } catch (SQLException e2) {
            e2.printStackTrace();
        } finally {
            DBConnect.close(pstmt, conn);
        }
        return true;
    }

    //修改方法
    @Override
    public boolean update(BookBean bm) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "update jwex3.图书信息表 set Name = ?,Price = ?,Publisher = ? where Num = ?";
            pstmt = conn.prepareStatement(sql);
            //设置占位符
            pstmt.setString(1, bm.getName());
            pstmt.setString(2, bm.getPrice());
            pstmt.setString(3, bm.getPublisher());
            pstmt.setString(4, bm.getNum());

            //执行SQL语句
            pstmt.execute();
        } catch (SQLException e3) {
            e3.printStackTrace();
        } finally {
            DBConnect.close(pstmt, conn);
        }
        return true;
    }

    //查询全表方法
    @Override
    public List<BookBean> findAll() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<BookBean> list = new ArrayList<BookBean>();
        BookBean bm = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "SELECT * FROM jwex3.图书信息表";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                bm = new BookBean();
                bm.setNum(rs.getString(1));
                bm.setName(rs.getString(2));
                bm.setPrice(rs.getString(3));
                bm.setPublisher(rs.getString(4));
                list.add(bm);
            }
        } catch (SQLException e4) {
            e4.printStackTrace();
        } finally {
            DBConnect.close(rs, stmt, conn);
        }
        return list;
    }

    //根据图书编号查找方法
    @Override
    public BookBean findByNum(String Num) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        BookBean bm = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM jwex3.图书信息表 where Num = ?");
            pStmt.setString(1, Num);
//            String sql = "SELECT * FROM jwex3.图书信息表 where Num = ?";
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                bm = new BookBean();
                bm.setNum(rs.getString(1));
                bm.setName(rs.getString(2));
                bm.setPrice(rs.getString(3));
                bm.setPublisher(rs.getString(4));
            }
        } catch (SQLException e5) {
            e5.printStackTrace();
        } finally {
            DBConnect.close(rs, stmt, conn);
        }
        return bm;
    }
}
