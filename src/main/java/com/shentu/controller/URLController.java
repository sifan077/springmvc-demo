/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/22
 * Time: 19:55
 * Describe: Url优先级控制器
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 *   "/resources/ima?e.png" - 匹配路径段中的一个字符
 *   "/resources/*.png" - 匹配路径段中的零个或多个字符
 *   "/resources/**" - 匹配多个路径段
 *   "/projects/{project}/versions" - 匹配路径段并将其【捕获为变量】
 *   "/projects/{project:[a-z]+}/versions" - 使用正则表达式匹配并【捕获变量】
 *   捕获的 URI 变量可以使用@PathVariable注解
 */
@Controller
@RequestMapping("/url")
public class URLController {
    /**
     * 匹配index路径
     *
     * @return String
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    /**
     * 匹配路径段中的一个字符
     *
     * @return String
     */
    @RequestMapping("/ima?e")
    @ResponseBody
    public String image() {
        return "image";
    }

    /**
     * 匹配路径段中的零个或多个字符
     *
     * @return String
     */
    @RequestMapping("/*png")
    @ResponseBody
    public String single() {
        return "single";
    }

    /**
     * 获取路径段中的变量
     *
     * @param id
     * @return String
     */
    @RequestMapping("/get/{id}/sf")
    @ResponseBody
    public String id(@PathVariable Long id) {
        System.out.println(id);
        return id + "";
    }

    /**
     * 正则表达式匹配
     *
     * @param project
     * @return String
     */
    @RequestMapping("/{project:[a-z]+}/versions")
    @ResponseBody
    public String zz(@PathVariable String project) {
        System.out.println(project);
        return "zz";
    }

    /**
     * 匹配所有页面，优先级最低
     *
     * @return String
     */
    @RequestMapping("/**")
    @ResponseBody
    public String all() {
        return "all";
    }

}
