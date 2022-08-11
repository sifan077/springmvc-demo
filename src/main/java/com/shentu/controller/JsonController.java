/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/23
 * Time: 16:05
 * Describe: json控制器
 */

package com.shentu.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/json")
@Controller
public class JsonController {


    /**
     * 返回List对象，拦截器会将对象转换为json字符串
     * @return List<User>
     */
    @RequestMapping(value = "/getAll", produces = "application/json;charset=UTF-8")
    //不走视图解析器
    @ResponseBody
    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        res.add(new User("张三", "123456", 18));
        res.add(new User("李四", "12ask456", 20));
        res.add(new User("王五", "123staffs6", 22));
        return res;
    }

    /**
     * 返回User对象，拦截器会将对象转换为json字符串
     * @return User对象
     */
    @RequestMapping(value = "/getOne", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User getOne() {
        return new User("张三", "123456", 18);
    }

    /**
     * 返回json字符串，如果配置了fastjson拦截器，则不能直接返回字符串，直接返回对象
     * 现在返回的是被json转移过的json字符串，具体怎么不让拦截器转义字符串，我还没想到
     * @return json字符串
     */
    @RequestMapping(value = "getResult", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getResult() {
        List<User> res = new ArrayList<>();
        res.add(new User("张三", "123456", 18));
        res.add(new User("李四", "12aka456", 20));
        res.add(new User("王五", "123staffs6", 22));
        System.out.println(JSON.toJSON(res).toString());
        return JSON.toJSON(res).toString();
    }

    /**
     * 测试获取值为null的情况
     * @return List<User>
     */
    @RequestMapping("get")
    @ResponseBody
    public List<User> get() {
        return Arrays.asList(new User("jack", 18), new User("rose", 19));
    }

}
