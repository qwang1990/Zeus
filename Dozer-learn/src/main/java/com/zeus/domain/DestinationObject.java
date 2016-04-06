package com.zeus.domain;

import org.dozer.Mapping;

import java.util.Date;

/**
 * Created by wangqi on 16/4/6.
 */
public class DestinationObject {
    private String username;
    private String password;
    private long age;
    private String gender;

    private SubItemDes subItemDes;

    public SubItemDes getSubItemDes() {
        return subItemDes;
    }

    public void setSubItemDes(SubItemDes subItemDes) {
        this.subItemDes = subItemDes;
    }

    @Mapping("birthday")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DestinationObject{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", subItemDes=" + subItemDes +
                ", date=" + date +
                '}';
    }
}
