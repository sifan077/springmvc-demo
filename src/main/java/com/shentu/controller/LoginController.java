/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 19:11
 * Describe:
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/app", produces = "text/html;charset=UTF-8")
public class LoginController {

    //跳转到登陆页面
    @RequestMapping("/jumplogin")
    public String jumpLogin() throws Exception {
        return "login";
    }

    //跳转到成功页面
    @RequestMapping("/jumpSuccess")
    public String jumpSuccess() throws Exception {
        return "success";
    }

    //登陆提交
    @RequestMapping(value = "/login")
    public String login(HttpSession session, String name, String password, Model model) throws Exception {
        // 向session记录用户身份信息
        System.out.println("接收前端=== " + name);
        session.setAttribute("user", name);
        model.addAttribute("user", name);
        return "success";
    }

    //退出登陆
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }

}
