package com.drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangqi on 16/5/9.
 */
@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
//@SpringBootApplication
public class ApplicationRun {
    @RequestMapping("/")
    String index() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
