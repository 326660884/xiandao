package cn.cnic.xiandao.config;

import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ConfigBean {
    @Bean
    public Mailer land() {
        return MailerBuilder
                .withSMTPServer("smtp.qq.com",587,"834875764@qq.com","cjkcretjiczcbfdh")
                .buildMailer();
    }

}
