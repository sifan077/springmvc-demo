/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/25
 * Time: 12:40
 * Describe: 字符串转日期
 */

package com.shentu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.expression.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}