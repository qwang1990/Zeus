package com.domian;

import com.object.Name;

/**
 * Created by wangqi on 16/4/10.
 */
public class NestedCommandBean {
    private Name name = new Name();
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NestedCommandBean{" +
                "name=" + name +
                '}';
    }
}
