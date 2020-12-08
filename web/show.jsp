<%@ page import="Service.impl.BookEBO" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.BookBean.BookBean" %>
<%@ page import="dao.impl.BookDAO" %>
<%@ page import="Common.druid.DBConnect" %>

<%--
  Created by IntelliJ IDEA.
  User: 15001
  Date: 2020/12/2
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--show界面通过数据业务层中定义的findAll的方法，
将数据库中的数据查询后返回到jsp页面--%>
<html>
<head>
    <title>图书信息展示表</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Num</td>
            <td>Name</td>
            <td>Price</td>
            <td>Publisher</td>
        </tr>
            <%
            BookEBO dao = new BookEBO();
            List<BookBean> list = dao.findAll();
            for (BookBean bm:list)
            {%>
            <tr>
                <td><%= bm.getNum() %></td>
                <td><%= bm.getName()%></td>
                <td><%= bm.getPrice()%></td>
                <td><%= bm.getPublisher()%></td>
            </tr>
            <%}
        %>
    </table>
    <div style="float: left" onclick="window.open('http://localhost:8080/JWEX3/add.jsp','_self')"><button>增</button></div>
    <div style="float: left" onclick="window.open('http://localhost:8080/JWEX3/delete.jsp','_self')"><button>删</button></div>
    <div style="float: left" onclick="window.open('http://localhost:8080/JWEX3/update.jsp','_self')"><button>改</button></div>
    <div style="float: left" onclick="window.open('http://localhost:8080/JWEX3/find.jsp','_self')"><button>查</button></div>

</body>
</html>
