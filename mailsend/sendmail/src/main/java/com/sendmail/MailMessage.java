package com.sendmail;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Properties;

/**
 * Created by wangqi on 16/6/13.
 */
public class MailMessage {
    private static String url = "http://sendcloud.sohu.com/webapi/mail.send.json";

    private static String user = "nich0las_test_OryXLQ";

    private static String key = "E7WNk4NdovbTlIcc";

    //private static String from = "warning@server.yimei180.com";
    private static String from = "auto_server@yimei180.com";


    public static boolean send(String to) throws IOException {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
/*
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername(from);
        javaMailSender.setPassword("Aa1234567890");
        javaMailSender.setJavaMailProperties(new Properties() {{
            put("mail.transport.protocol", "smtp");
            put("mail.smtp.auth", true);
            put("mail.smtp.starttls.enable", true);
            put("mail.debug", true);
        }});*/

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("warning@server.yimei180.com");
        msg.setTo(to.split(";"));
        msg.setSubject(ZonedDateTime.now().toString() + " " + "hehe");
        //msg.setText("requestHeader:\t" + requestHeader + "\nrequestUrl:\t" + requestUrl + "\nformData:\t" + formData + "\ncurrentUser:\t" + user + "\n" + ex.getMessage() + " " + getStackTrace(ex));
        msg.setText("hahahahah");
        try {
            javaMailSender.send(msg);
        } catch (Exception x) {
            System.out.println("SimpleMailMessage发送报警邮件失败："+x);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("线上错误重现");
        if (args.length != 1) {
            System.out.println("请输入邮箱地址");
            System.exit(0);
        }
        MailMessage.send(args[0]);
    }

}

class ReturnBody{

    String message ;

    List<String> errors ;

    public boolean isSuccess(){
        return "success".equals(message) ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ReturnBody{" +
                "message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }

}
