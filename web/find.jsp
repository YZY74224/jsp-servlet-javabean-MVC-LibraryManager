<%--
  Created by IntelliJ IDEA.
  User: 15001
  Date: 2020/12/6
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按照Num值查找</title>
</head>
<body>
<form action="Table" method="post">
    <input type="hidden" name="submitFlag" value="find">
    <table width="20%" align="center">
        <tr>
            <td colspan="3" align="center">按照图书编号查找图书</td>
        </tr>
        <tr>
            <td align="right">输入要查找的图书编号:</td>
            <td><input type="text" name="Num"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit"value="保存"/><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
