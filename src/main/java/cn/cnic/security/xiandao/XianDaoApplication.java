package cn.cnic.security.xiandao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class XianDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XianDaoApplication.class);
    }
}
