package cn.cnic.xiandao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *  WebMvcConfigurerAdapter 已经作废
 *
 *
 *
 */
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {




    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    /**
     * 配置请求视图映射
     */
//    @Bean
//    public InternalResourceViewResolver resourceViewResolver()
//    {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        //请求视图文件的前缀地址
//        internalResourceViewResolver.setPrefix("classpath:/views/");
//        //请求视图文件的后缀
//        internalResourceViewResolver.setSuffix(".html");
//        return internalResourceViewResolver;
//    }


}
