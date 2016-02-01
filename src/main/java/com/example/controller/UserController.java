package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by SunYi on 2016/2/1/0001.
 */
@Controller
//控制类，控制页面跳转，数据传输
public class UserController {
    @RequestMapping("")
    public String index(HttpServletResponse response) {
        //跳转链接，跳转到主页
       return response.encodeRedirectURL("/index");
    }

    @RequestMapping("/index")
    public String home(Model model) {
        return "index";
    }
}
