package com.zeus.object;

import org.dozer.Mapping;

import java.util.Date;
import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
enum Status {
    PROCESSING, SUCCESS, ERROR
}

public class SourceObject {

    private Status status;
    private String username;
    private String password;
    private int age;
   // @Mapping("gender")
    private boolean alive;

    private Date birthday;

    private List<SubItem> subItemList;

  //  @Mapping("subItemDes")
    private SubItem subItem;

    public SourceObject() {
        status = Status.SUCCESS;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SubItem getSubItem() {
        return subItem;
    }

    public void setSubItem(SubItem subItem) {
        this.subItem = subItem;
    }

    public Date getBirthday() {
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

    public List<SubItem> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<SubItem> subItemList) {
        this.subItemList = subItemList;
    }


    @Override
    public String toString() {
        return "SourceObject{" +
                "status=" + status +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", birthday=" + birthday +
                ", subItemList=" + subItemList +
                ", subItem=" + subItem +
                '}';
    }
}
