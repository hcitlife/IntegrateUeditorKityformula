package com.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
public class DemoController {

    @ResponseBody
    @RequestMapping("/d1")
    public void demo1(HttpServletRequest request) throws IOException {
        ServletInputStream is = request.getInputStream();
        String str = inputStream2String(is, "UTF-8");
        System.out.println("用户在UEditor中输入的内容是：" + str);
    }

    public static String inputStream2String(InputStream is, String encode) {
        String str = "";
        try {
            if (encode == null || encode.equals("")) {
                encode = "utf-8";// 默认以utf-8形式
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is, encode));
            StringBuffer sb = new StringBuffer();

            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    @ResponseBody
    @RequestMapping("/d2")
    public void demo2(HttpServletRequest request) throws IOException {
        String data = request.getParameter("data");
        System.out.println(data);
    }

    @ResponseBody
    @RequestMapping("/d3")
    public void demo3(String name,String editorValue) throws IOException {
        System.out.println("doGet");
        System.out.println(name);
        System.out.println(editorValue);
    }
}
