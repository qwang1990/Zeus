package com.wisely.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangqi on 16/4/13.
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String hello() {
        System.out.println("hahhahah");
        return "index";
    }
}
