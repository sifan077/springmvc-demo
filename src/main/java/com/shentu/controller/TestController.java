/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/16
 * Time: 16:25
 * Describe: 控制器注解使用
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    /**
     * 返回视图
     * @return ModelAndView
     */
    @RequestMapping("/test1")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello test1");
        mv.setViewName("hello");
        return mv;
    }

    /**
     * 返回视图
     * @return ModelAndView
     */
    @RequestMapping("/test2")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello test2");
        mv.setViewName("hello");
        return mv;
    }

    /**
     * 返回视图
     * @return ModelAndView
     */
    @RequestMapping("/test3")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello test3");
        mv.setViewName("hello");
        return mv;
    }
}
