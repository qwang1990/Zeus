package com.zeus.domain;

import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
public class SubItemDes {
    private String add;
    private List<String> fam;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public List<String> getFam() {
        return fam;
    }

    public void setFam(List<String> fam) {
        this.fam = fam;
    }

    @Override
    public String toString() {
        return "SubItemDes{" +
                "add='" + add + '\'' +
                ", fam=" + fam +
                '}';
    }
}
