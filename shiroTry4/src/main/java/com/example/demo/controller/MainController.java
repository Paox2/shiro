package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginLogic(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 登录失败会抛出异常，则交由异常解析器处理
        token.setRememberMe(true);
        subject.login(token);

        return "main";
    }

    @GetMapping("/register")
    public String regiter() {
        return "register";
    }


    @PostMapping("/register")
    public String logicRegiter(User user) {
        userService.addUser(user);
        return "redirect:login";
    }

    @GetMapping("/testFind")
    @ResponseBody
    public User testFind() {
        User user = userService.findUserByUsername("Jack");
        return user;
    }
}
