package cn.cnic.xiandao.service.impl;


import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailNotice {
    public void constructMail(String destName,String destEmail,String describeEvent) throws IOException {
      Email email = EmailBuilder.startingBlank()
              .from("中科院计算机网络信息中心","834875764@qq.com")
              .to(destName,destEmail)
              //.withHeader("X-Priority", 2)
              .withSubject("通知")
              .withPlainText(describeEvent)
              .buildEmail();
      String host = "smtp.qq.com";
      int port = 587;
      String username = "834875764@qq.com";
      String password = "cjkcretjiczcbfdh";

      MailerBuilder
              .withSMTPServer(host,port,username,password)
              .buildMailer()
              .sendMail(email,true);



    }





}
