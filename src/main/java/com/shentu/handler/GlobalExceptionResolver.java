/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 16:16
 * Describe: 实现接口来处理全局异常，需要在springmvc.xml中配置或者在类中写注解
 */

package com.shentu.handler;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
