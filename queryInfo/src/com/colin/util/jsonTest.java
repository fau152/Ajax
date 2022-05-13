package com.colin.util;

import com.colin.entity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 这个类用来演示如何将一个java对象转换为json
 */
public class jsonTest {
    public static void main(String[] args) {
        Province province = new Province(1, "甘肃", "甘", "兰州");
        //使用jackson把province转换为json
        ObjectMapper om = new ObjectMapper();
        try {
            //writeValueAsString把参数的java对象转换为json格式的字符串
            String json = om.writeValueAsString(province);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
