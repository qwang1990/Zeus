package com.wisely.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wangqi on 16/7/4.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG="world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HelloServiceProperties{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
