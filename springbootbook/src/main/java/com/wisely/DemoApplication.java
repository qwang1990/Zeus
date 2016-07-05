package com.wisely;

import com.lowagie.text.DocumentException;
import com.wisely.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.HelloService;

import java.io.IOException;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Value("${book.author}")
    private String bookah;

    @Autowired
    private AuthorSettings authorSettings;

    @Autowired
    HelloService helloService;

	@RequestMapping(value = "/")
    String index() throws IOException, DocumentException {
        return "hello world "+authorSettings.getName() + " age: "+authorSettings.getAge();
    }

    @RequestMapping(value = "/hello")
    String hello() throws IOException, DocumentException {
        return helloService.sayHello();
    }




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
