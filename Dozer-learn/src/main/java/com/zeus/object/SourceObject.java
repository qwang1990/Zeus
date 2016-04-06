package com.zeus.object;

import org.dozer.Mapping;

import java.util.Date;
import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
public class SourceObject {

    private String username;
    private String password;
    private int age;
   // @Mapping("gender")
    private boolean alive;

    private Date birthday;

  //  @Mapping("subItemDes")
    private SubItem subItem;

    public SubItem getSubItem() {
        return subItem;
    }

    public void setSubItem(SubItem subItem) {
        this.subItem = subItem;
    }

    public Date getBirthday() {
        System.out.println("executed here!");
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public String toString() {
        return "SourceObject{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", birthday=" + birthday +
                ", subItem=" + subItem +
                '}';
    }
}
