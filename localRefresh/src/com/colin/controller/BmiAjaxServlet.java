package com.colin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String name = req.getParameter("name");
        String w = req.getParameter("weight");
        String h = req.getParameter("height");
        float weight = Float.valueOf(w);
        float height = Float.valueOf(h);

        //计算bmi值
        float bmi = weight / (height * height);

        //根据bmi值生成最终结果
        String msg = "";
        if(bmi < 18.5){
            msg = "过轻";
        }else if(bmi <= 23.9){
            msg = "正常";
        }else if(bmi <= 27){
            msg = "过重";
        }else if(bmi <= 32){
            msg = "肥胖";
        }else{
            msg = "非常肥胖";
        }
        System.out.println("msg:" + msg);
        msg = name + "先生/女士，您的bmi值为" + bmi + "，评估结果为：" + msg;

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(msg);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
