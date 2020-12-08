<%@ page import="Entity.BookBean.BookBean" %>
<%@ page import="Service.impl.BookEBO" %><%--
  Created by IntelliJ IDEA.
  User: 15001
  Date: 2020/12/6
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询修改结果</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>图书编号</td>
            <td>图书书名</td>
            <td>图书价格</td>
            <td>图书出版社</td>
        </tr>
        <%
            BookEBO dao = new BookEBO();
            BookBean bm = dao.findByNum(request.getParameter("Num"));
            %>
        <tr>
            <td><%= bm.getNum()%>></td>
            <td><%= bm.getName()%>></td>
            <td><%= bm.getPrice()%>></td>
            <td><%= bm.getPublisher()%>></td>
        </tr>
    </table>
</body>
</html>
