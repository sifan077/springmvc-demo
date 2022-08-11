/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/22
 * Time: 20:16
 * Describe:  主要服务于获取参数 和 字符串json转化使用
 */

package com.shentu.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String name;
    private String password;
    private int age;

    // 对象和json互相转化的过程当中按照此转化方式转哈
    @JsonFormat(
            pattern = "yyyy年MM月dd日",
            timezone = "GMT-8"
    )
    // 从requestParam中获取参数并且转化
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.password = 123456 + "";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
