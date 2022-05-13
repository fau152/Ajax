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
            //获取到json格式的字符串
            var data = xhr.responseText;
            //创建jsonObject
            var jsonObj = eval('(' + data + ')');
            //更新dom对象
            document.getElementById('proname').value = jsonObj.name;
            document.getElementById('projiancheng').value = jsonObj.jiancheng;
            document.getElementById('proshenghui').value = jsonObj.shenghui;
          }
        }
        var proid = document.getElementById('proid').value;
        //3. 打开链接
        //true: 异步处理请求。使用异步对象发起请求后，不用等待数据处理完毕，就可以执行其他操作。
        //false: 同步处理请求。异步对象必须处理完成请求，从服务器获取数据后，才可以执行send()之后的代码。
        //就是说异步的时候，甚至可以定义多个异步对象，同时发起请求，互不干扰，多个线程处理。
        // 而同步的时候，必须等异步对象处理完请求之后才能接着执行后面的操作，相当于单线程，所以基本不用。
        xhr.open('get', 'searchJsonProvince?proid='+proid, 'true');
        //4. 发送请求
        xhr.send();

        //当我们在servlet中下一个断点，使得服务器暂时不返回数据，
        // 此时如果是异步的话下面的alert会继续执行，而同步的话在接收到servlet的数据之后才执行
        alert('断点停止后，异步执行，同步不执行');
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
        <tr>
          <td>省会城市：</td>
          <td><input type="text" id="proshenghui"></td>
        </tr>
      </table>
    </div>
  </body>
</html>
