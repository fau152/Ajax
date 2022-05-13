<%--
  Created by IntelliJ IDEA.
  User: wangl
  Date: 2021/11/6
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax根据省份的id获取省份的名称</title>
    <script type="text/javascript">
      function search(){
        //1. 创建XMLHttpRequest对象
        var xhr = new XMLHttpRequest();
        //2. 绑定事件
        xhr.onreadystatechange = function (){
          if(xhr.readyState == 4 && xhr.status == 200){
            document.getElementById('proname').value = xhr.responseText;
          }
        }
        var proid = document.getElementById('proid').value;
        //3. 打开链接
        xhr.open('get', 'searchProvince?proid='+proid, 'true');
        //4. 发送请求
        xhr.send();
      }
    </script>
  </head>
  <body>
    <div id="center">
      <table>
        <tr>
          <td>省份编号：</td>
          <td><input type="text" id="proid"><input type="button" value="搜索" onclick="search()"></td>
        </tr>
        <tr>
          <td>省份名称：</td>
          <td><input type="text" id="proname"></td>
        </tr>
        <tr>
          <td>省份简称：</td>
          <td><input type="text" id="projiancheng"></td>
        </tr>
      </table>
    </div>
  </body>
</html>
