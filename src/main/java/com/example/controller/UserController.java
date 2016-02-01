package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by SunYi on 2016/2/1/0001.
 */
@Controller
//控制类，控制页面跳转，数据传输
public class UserController {
    //自动注入userService，用来处理业务
    @Autowired
    private UserService userService;

    //跳转链接，跳转到主页
    @RequestMapping("")
    public String index(HttpServletResponse response) {
        //重定向到 /index
        return response.encodeRedirectURL("/index");
    }

    //真正主页
    @RequestMapping("/index")
    public String home(Model model) {
        //对应到templates文件夹下面的index
        return "index";
    }

    //进入注册页面，使用Get请求
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet() {
        return "register";
    }

    //注册用户，使用POST，传输数据
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(Model model,
                               //这里和模板中的th:object="${user}"对应起来
                               @ModelAttribute(value = "user") User user,
                               HttpServletResponse response) {
        String result = userService.register(user);
        //将结果放入model中，在模板中可以取到model中的值
        model.addAttribute("result", result);
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model,
                            @ModelAttribute(value = "user") User user,
                            HttpServletResponse response,
                            HttpSession session) {
        String result = userService.login(user);
        if (result.equals("登陆成功")) {
            //添加到session中，session是一次会话，在本次会话中都可以取到session中的值
            //若是session中有用户存在则会覆盖原来的user，当session中的user存在时判定用户存在
            session.setAttribute("user",user);
        }
        model.addAttribute("result", result);
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        //从session中删除user属性，用户退出登录
        session.removeAttribute("user");
        return "index";
    }
}
