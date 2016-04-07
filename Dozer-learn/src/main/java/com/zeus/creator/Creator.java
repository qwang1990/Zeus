package com.zeus.creator;

public interface Creator<T> {

    public T create(Object source);
}
