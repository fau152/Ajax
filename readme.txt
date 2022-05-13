这个项目演示了ajax的使用：
globalRefresh演示了全局刷新的效果：
    1. 转发的方式
    2. resp.getWriter().println()的方式
localRefresh演示了局部刷新的效果
queryInfo演示了使用ajax做异步请求并通过jdbc查询数据库
    1. index.jsp 使用ajax根据省编号查询省的名字，只有一个条数据交换
    2. indexjson.jsp 使用ajax请求根据省编号更新省名字、简称、省会等信息，多条数据交换（使用json格式传输）

------------------------------------
readyState状态：

0 new XmlHttpRequest() 这一步我们无法在浏览器F12时看到
1 open()的时候，从0变为1
2 send()的时候，从1变为2，在调试的时候，这时会出现请求，并且触发原因中显示的时xhr（XmlHttpRequest）
3 异步对象从服务器接收到了应答数据
4 异步对象将应答数据解析成功
-------------------------------------
js发送get和post请求：https://www.cnblogs.com/Im-Victor/p/9405974.html
关于请求头中的ContextType，参阅：https://www.cnblogs.com/yanggb/p/11684494.html