package com.wisely.service;

/**
 * Created by wangqi on 16/7/4.
 */
public class HelloService {
    private String msg;

    public String sayHellp() {
        return "hello"+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
