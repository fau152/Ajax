<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax局部刷新计算bmi</title>
    <script type="text/javascript">
      function doAjax() {
        //1.创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2. 绑定事件
        xmlHttp.onreadystatechange = function (){
          //处理服务器返回的数据，更新当前页面
          //alert("readyState==" + xmlHttp.readyState + "statues" + xmlHttp.status);
          if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = document.getElementById('result');
            result.innerText = xmlHttp.responseText;
          }
        }
        //初始请求数据
        var name = document.getElementById('name').value;
        var weight = document.getElementById('weight').value;
        var height = document.getElementById('height').value;
        //发送post请求
        //3. 打开链接
        xmlHttp.open('post', 'bmiAjax', true);
        //设置请求头
        xmlHttp.setRequestHeader('Content-type','application/x-www-form-urlencoded;charset=utf-8');
        //4. 发送请求，请求体写在send中
        xmlHttp.send('name='+name+'&weight='+weight+'&height='+height);
      }
    </script>
  </head>
  <body>
    <p>ajax局部刷新计算bmi</p>
    <div>
      <%--
      这里没有使用form表单
       ajax请求不是使用form提交的，所以有没有form都无所谓。
      --%>
      姓名：<input type="text" name="name" id="name"><br>
      体重（kg）：<input type="text" name="weight" id="weight"><br>
      身高（m）：<input type="text" name="height" id="height"><br>
      <input type="submit" value="提交" onclick="doAjax()">
      <br>
      <br>
      <p id="result">结果等待更新……</p>
    </div>
  </body>
</html>
