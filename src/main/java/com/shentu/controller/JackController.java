/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 12:21
 * Describe: JackJson 使用和配置
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/jack",produces = "application/json;charset=UTF-8")
public class JackController {

    /**
     * jackJson 使用 Null值 不会发送到前端
     * @return List<User>
     */
    @RequestMapping("get")
    @ResponseBody
    public List<User> get() {
        return Arrays.asList(new User("jack", 18), new User("rose", 19));
    }
    @RequestMapping("getDate")
    @ResponseBody
    public User getDate(User user) {
        System.out.println(user);
        return user;
    }
}
