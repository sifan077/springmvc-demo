/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/22
 * Time: 20:14
 * Describe: 传入参数控制器
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/para",produces = "application/json;charset=UTF-8")
public class ParametersController {

    /**
     * 体验最初的接收参数方式
     *
     * @param name
     * @param age
     * @return 相应字符串
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test(String name, int age) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        return "success";
    }

    //同上
    @RequestMapping("login")
    @ResponseBody
    public String login(String name, String password) {
        System.out.println(name);
        System.out.println(password);
        return "login";
    }

    /**
     * 直接获取参数对象，需要前端传入的参数与后端实体类的属性名相同
     *
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public String register(User user) {
        System.out.println(user);
        return "register";
    }

    /**
     * 通过注解@RequestParam获取参数
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/requestParam")
    @ResponseBody
    public String get(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println(name);
        System.out.println(age);
        return "get";
    }

    /**
     * 通过注解@RequestHeader获取参数
     *
     * @param encoding
     * @return
     */
    @GetMapping("/requestParam2")
    @ResponseBody
    public String get2(@RequestHeader("Accept-Encoding") String encoding) {
        System.out.println(encoding);
        return "get2";
    }

    /**
     * 通过注解@CookiesValue获取参数
     *
     * @param jsessionid
     * @return
     */
    @GetMapping("/requestParam3")
    @ResponseBody
    public String get3(@CookieValue("JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
        return "get3";
    }

    /**
     * required = true，表示必须传入参数
     * @param name
     * @param encoding
     * @param jsessionid
     * @param sessionId
     * @return
     */
    @RequestMapping("/requestParam4")
    @ResponseBody
    public String get4(
            @RequestParam(required = false) String name,
            @RequestHeader(required = false) String encoding,
            @CookieValue(required = false) String jsessionid,
            @SessionAttribute(required = false) String sessionId
    ) {
        System.out.println("name = " + name);
        System.out.println("encoding = " + encoding);
        System.out.println("jsessionid = " + jsessionid);
        System.out.println("sessionId = " + sessionId);
        return "get4";
    }

    /**
     * 创建sessionId，通过页面转发把sessionId在别的页面获取，
     * 但是跳转好像有点问题，没有跳转到别的页面
     * @param request
     * @return
     */
    @GetMapping("/goRequestParam4")
    @ResponseBody
    public String goRequestParam4(HttpServletRequest request) {
        request.setAttribute("sessionId", "张三");
        System.out.println("sessionId = " + request.getAttribute("sessionId"));
        return "forward:/requestParam4";
    }

    /**
     * 传入数组
     * @param arrays
     * @return
     */
    @RequestMapping("/requestParam5")
    @ResponseBody
    public String get5(@RequestParam("arrays") String[] arrays) {
        System.out.println(Arrays.toString(arrays));
        return "get5";
    }
}
