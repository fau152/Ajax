package com.colin.dao;

import com.colin.entity.Province;

import java.sql.*;

public class ProvinceDao {
    public String selectPronameById(Integer proid){
        //声明变量
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String resultName = null;
        String url = "jdbc:mysql://localhost:3306/ajaxtest";
        String username = "root";
        String password = "wanglong";

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn = DriverManager.getConnection(url, username, password);
            //设置sql语句
            String sql = "select name from province where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,proid);
            //查询
            rs = ps.executeQuery();
            //处理结果
            if(rs.next()){
                resultName = rs.getString("name");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return resultName;
    }

    public Province selectProvince(Integer proid){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Province pro = null;
        String url = "jdbc:mysql://localhost:3306/ajaxtest";
        String username = "root";
        String password = "wanglong";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select id,name,jiancheng,shenghui from province where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proid);
            rs = ps.executeQuery();
            if(rs.next()){
                pro = new Province();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setJiancheng(rs.getString("jiancheng"));
                pro.setShenghui(rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return pro;
    }
}
