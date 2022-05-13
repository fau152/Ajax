package com.colin.controller;

import com.colin.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 实现功能：输入省的编号，显示对应的省名称
 */
public class ProvinceServlet extends HttpServlet {
    private ProvinceDao provinceDao = new ProvinceDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取省编号porid
        String proid = req.getParameter("proid");
        //省的名称默认值（如果没有输入的话点击搜索之后显示这个）
        String proName = "--";
        //判断用户是否输入了省的编号
        if(proid != null && proid.trim().equals("")){
            proName = provinceDao.selectPronameById(Integer.valueOf(proid));
        }
        //返回数据给浏览器
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(proName);
        pw.flush();
        pw.close();
    }
}
