package com.haodai.topadvisor.bean;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/3/4 14:36
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class User {
    public String name;
    public String password;
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
