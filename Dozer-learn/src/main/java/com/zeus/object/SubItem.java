package com.zeus.object;

import org.dozer.Mapping;

import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
public class SubItem {
  //  @Mapping("add")
    private String address;
  //  @Mapping("fam")
    private List<String> family;

    private int size;

    public SubItem() {
    }

    public SubItem(String address, List<String> family,int size) {
        this.address = address;
        this.family = family;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "SubItem{" +
                "address='" + address + '\'' +
                ", family=" + family +
                ", size=" + size +
                '}';
    }
}
