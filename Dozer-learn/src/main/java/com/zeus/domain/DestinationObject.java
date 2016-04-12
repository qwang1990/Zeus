package com.zeus.domain;

import com.zeus.object.SubItem;
import org.dozer.Mapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
enum DestinatoinStatus {
    PROCESSING, SUCCESS, ERROR
}

public class DestinationObject {
    private String username;
    private String password;
    private long age;
    private String gender;
    private DestinatoinStatus destinatoinStatus;
    private LocalDate localDate;

    private SubItemDes subItemDes;

    private List<SubItemDes> subItemList;

    private String specialValue;

    public String getSpecialValue() {
        return specialValue;
    }

    public void setSpecialValue(String specialValue) {
        this.specialValue = specialValue;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public SubItemDes getSubItemDes() {
        return subItemDes;
    }

    public void setSubItemDes(SubItemDes subItemDes) {
        this.subItemDes = subItemDes;
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SubItemDes> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<SubItemDes> subItemListt) {
        this.subItemList = subItemListt;
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

    public DestinatoinStatus getDestinatoinStatus() {
        return destinatoinStatus;
    }

    public void setDestinatoinStatus(DestinatoinStatus destinatoinStatus) {
        this.destinatoinStatus = destinatoinStatus;
    }

    @Override
    public String toString() {
        return "DestinationObject{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", destinatoinStatus=" + destinatoinStatus +
                ", localDate=" + localDate +
                ", subItemDes=" + subItemDes +
                ", subItemList=" + subItemList +
                ", specialValue='" + specialValue + '\'' +
                ", date=" + date +
                '}';
    }
}
