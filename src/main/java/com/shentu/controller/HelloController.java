/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/16
 * Time: 15:56
 * Describe: 实现接口实现Controller类
 */

package com.shentu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    /*
     * 返回ModelAndView对象
     * 最简单的Controller，通过实现Controller接口，可以实现自己的Controller
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello Spring MVC");
        // /WEB-INF/page/hello.jsp
        mv.setViewName("hello");
        return mv;
    }
}
