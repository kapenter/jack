package com.zcd.controller;

import com.zcd.entity.User;
import com.zcd.interfaces.IUserInterface;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-05 17:38
 **/
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private IUserInterface userInterface;


    @RequestMapping("/toLogin")
    public  String toLogin(){
        return "login";
    }



    @RequestMapping(value="/login/session" ,method = RequestMethod.POST)
    public String login(User user) {
        String userName="zhangSan";
        String passWord="123456";
        UsernamePasswordToken  token=new UsernamePasswordToken(userName,passWord);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (IncorrectCredentialsException ice) {
            return "redirect:/login";
        }
        subject.getSession().setAttribute("user",userInterface.selectUserByName(userName));
        return  "redirect:/seckill/list";
    }




    @RequestMapping("/getUser")
    public User getUser() {
        Subject subject=SecurityUtils.getSubject();
        User user=(User)subject.getSession().getAttribute("user");
        System.out.println(user);
        return  user;
    }

}
