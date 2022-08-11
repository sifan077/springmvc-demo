/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 13:13
 * Describe: 数据校验
 */

package com.shentu.controller;
/*
 *   @Null	被注解的元素必须为 null
 *   @NotNull	被注解的元素必须不为 null
 *   @AssertTrue	被注解的元素必须为 true
 *   @AssertFalse	被注解的元素必须为 false
 *   @Min(value)	被注解的元素必须是一个数字，其值必须大于等于指定的最小值
 *   @Max(value)	被注解的元素必须是一个数字，其值必须小于等于指定的最大值
 *   @DecimalMin(value)	被注解的元素必须是一个数字，其值必须大于等于指定的最小值
 *   @DecimalMax(value)	被注解的元素必须是一个数字，其值必须小于等于指定的最大值
 *   @Size(max, min)	被注解的元素的大小必须在指定的范围内
 *   @Digits (integer, fraction)	被注解的元素必须是一个数字，其值必须在可接受的范围内
 *   @Past	被注解的元素必须是一个过去的日期
 *   @Future	被注解的元素必须是一个将来的日期
 *   @Pattern(value)	被注解的元素必须符合指定的正则表达式
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/data", produces = "application/json;charset=UTF-8")
@Slf4j
public class DataValidationController {

    @RequestMapping(value = "get", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object get(@Validated Student student, BindingResult br) {
        List<ObjectError> allErrors = br.getAllErrors();
        Iterator<ObjectError> iterator = allErrors.iterator();
        // 打印以下错误结果
        while (iterator.hasNext()) {
            ObjectError error = iterator.next();
            log.error("user数据校验错误:{}", error.getDefaultMessage());
        }

        if (allErrors.size() > 0) {
            return "error";
        }

        System.out.println(student);
        return "success";
    }
}
