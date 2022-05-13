package com.colin.controller;

import com.colin.dao.ProvinceDao;
import com.colin.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProvinceJsonServlet extends HttpServlet {
    private ProvinceDao provinceDao = new ProvinceDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，省份的id
        String proid = req.getParameter("proid");
        //默认值，{}：表示json格式数据
        String jsonString = "{}";
        //判断proid有值时，调用dao查询数据
        if(proid != null && proid.trim().length() > 0){
            Province pro = provinceDao.selectProvince(Integer.valueOf(proid));
            ObjectMapper om = new ObjectMapper();
            //使用jackson把Object转换为json
            jsonString = om.writeValueAsString(pro);
        }

        //指定服务器端（servlet）返回给浏览器的数据是json格式的数据
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(jsonString);
        pw.flush();
        pw.close();
    }
}
