package com.wisely;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.wisely.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Value("${book.author}")
    private String bookah;

    @Autowired
    private AuthorSettings authorSettings;

	@RequestMapping("/")
    String index() throws IOException, DocumentException {
        return "hello world "+authorSettings.getName() + " age: "+authorSettings.getAge();
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
