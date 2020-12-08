<%--
  Created by IntelliJ IDEA.
  User: 15001
  Date: 2020/12/5
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增图书界面</title>
</head>
<body>
<form action="Table" method="post">
    <input type="hidden" name="submitFlag" value="add">
    <table width="20%" align="center">
        <tr>
            <td colspan="3" align="center">新增图书</td>
        </tr>
        <tr>
            <td align="right">图书编号:</td>
            <td><input type="text" name="Num"></td>
        </tr>
        <tr>
            <td align="right">图书书名:</td>
            <td><input type="text" name="Name"></td>
        </tr>
        <tr>
            <td align="right">图书价格:</td>
            <td><input type="text" name="Price"></td>
        </tr>
        <tr>
            <td align="right">图书出版社:</td>
            <td><input type="text" name="Publisher"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存"/>&nbsp;&nbsp;<input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
