package Controller;

import Common.druid.MyUtils;
import Entity.BookBean.BookBean;
import Service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:The King Of the World
 * @Date:2020/12/5
 * @Description:Controller
 * @version：1.0
 */
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String submitFlag = req.getParameter("submitFlag");
        //如果提交flag是find，那么调用findByNum方法
        if ("find".equals(submitFlag)) {
            this.findByNum(req);
            BookBean bm = ServiceFactory.getBookEBO().findByNum(req.getParameter("Num"));
            System.out.println(req.getParameter("Num"));
            PrintWriter out = resp.getWriter();
            out.print("<!DOCTYPE HTML>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset='utf-8'>");
            out.print("</head>");
            out.print("<body>");
            out.print("<table align = 'center' width='40%'>");
            out.print("<tr>");
            out.print("<td>图书编号</td>");
            out.print("<td>图书书名</td>");
            out.print("<td>图书价格</td>");
            out.print("<td>图书出版社</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>" + bm.getNum() + "</td>");
            out.print("<td>" + bm.getName() + "</td>");
            out.print("<td>" + bm.getPrice() + "</td>");
            out.print("<td>" + bm.getPublisher() + "</td>");
            out.print("</tr>");
            out.print("</table>");
            out.print("</body>");
            out.print("</+html>");
            //resp.sendRedirect("http://localhost:8080/JWEX3/findResult.jsp");
        }
        //如果提交flag是update，那么调用修改方法
        if ("update".equals(submitFlag)) {
            if (this.update(req)) {
                resp.sendRedirect("http://localhost:8080/JWEX3/show.jsp");
            }
        }
        //如果提交flag是delete,那么调用删除方法
        if ("delete".equals(submitFlag)) {
            if (this.delete(req)) {
                resp.sendRedirect("http://localhost:8080/JWEX3/show.jsp");
            }
        }
        //如果提交flag是add,那么调用新增方法
        if ("add".equals(submitFlag)) {
            if (this.add(req)) {
                //List<BookBean> list = ServiceFactory.getBookEBO().findAll();
                resp.sendRedirect("http://localhost:8080/JWEX3/show.jsp");
            }
        }
    }

    private boolean add(HttpServletRequest req) {
        BookBean bm = new BookBean();
        //收集请求的数据，创建BookBean的实例，并设置其属性
        bm.setNum(MyUtils.toChinese(req.getParameter("Num")));
        bm.setName(MyUtils.toChinese(req.getParameter("Name")));
        bm.setPrice(MyUtils.toChinese(req.getParameter("Price")));
        bm.setPublisher(MyUtils.toChinese(req.getParameter("Publisher")));
        return ServiceFactory.getBookEBO().create(bm);
    }

    private boolean delete(HttpServletRequest req) {
        String Num = null;
        //获取请求中要求修改的主键Num，设置其属性
        Num = req.getParameter("Num");
        return ServiceFactory.getBookEBO().delete(Num);
    }

    private boolean update(HttpServletRequest req) {
        BookBean bm = new BookBean();
        //收集请求的数据，创建BookBean的实例，并设置其属性
        bm.setNum(MyUtils.toChinese(req.getParameter("Num")));
        bm.setName(MyUtils.toChinese(req.getParameter("Name")));
        bm.setPrice(MyUtils.toChinese(req.getParameter("Price")));
        bm.setPublisher(MyUtils.toChinese(req.getParameter("Publisher")));
        return ServiceFactory.getBookEBO().update(bm);
    }

    private BookBean findByNum(HttpServletRequest req) {
        String Num = null;
        //获取请求中要求查找的主键Num，返回其所在的BookBean
        Num = req.getParameter("Num");
        return ServiceFactory.getBookEBO().findByNum(Num);
    }

}
