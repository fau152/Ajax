<%--
  Created by IntelliJ IDEA.
  User: wangl
  Date: 2021/11/5
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>计算bmi</title>
  </head>
  <body>
    <p>全局刷新计算bmi</p>
    <form action="bmiPrintServlet" method="get">
      姓名：<input type="text" name="name"><br>
      体重（kg）：<input type="text" name="weight"><br>
      身高（m）：<input type="text" name="height"><br>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
