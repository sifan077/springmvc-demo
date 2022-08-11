/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 16:22
 * Describe:
 */

package com.shentu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionResolverController {

    @ExceptionHandler(ArithmeticException.class)
    public String processArithmeticException(ArithmeticException ex) {
        log.error("发生了数学类的异常：", ex);
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String processNullPointerException(NullPointerException ex) {
        log.error("发生了空指针异常：", ex);
        return "error";
    }
}
