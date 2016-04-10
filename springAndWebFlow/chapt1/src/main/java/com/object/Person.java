package com.object;

import java.util.Date;

/**
 * Created by wangqi on 16/4/10.
 */
public class Person {
    private Name name = new Name();
    private Date bornOn;
    private String favoriteProgrammingLanguage;
    public Date getBornOn() {
        return bornOn;
    }
    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }
    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: [");
        sb.append(name.toString());
        sb.append("], ");
        sb.append("Born On: [");
        sb.append(bornOn);
        sb.append("], ");
        sb.append("Favorite Programming Language: [");
        sb.append(favoriteProgrammingLanguage);
        sb.append("]");
        return sb.toString();
    }
}


