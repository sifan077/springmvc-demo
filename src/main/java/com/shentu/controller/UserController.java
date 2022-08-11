/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/16
 * Time: 16:58
 * Describe:  RequestMapping和衍生注解基本使用
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello2")
    public String hello(Model model) {
        model.addAttribute("message", "Hello Model");
        return "hello";
//        return "redirect:http://www.baidu.com"; //重定向
//        return "forward:http://www.baidu.com"; //转发
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        return "login";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String add() {
        return "add";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            params = {"username", "password"}, headers = {"Accept=application/json"},
            consumes = {"application/json"}, produces = {"application/json"})
    @ResponseBody
    public String insert(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("insert");
        return "insert";
    }

    @GetMapping("getOne")
    @ResponseBody
    public String getOne() {
        return "user";
    }

    @PostMapping("insert1")
    @ResponseBody
    public String insert1() {
        return "user";
    }

    @PutMapping("update")
    @ResponseBody
    public String update() {
        return "user";
    }

    @DeleteMapping("delete")
    @ResponseBody
    public String delete() {
        return "user";
    }
}
