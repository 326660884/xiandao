package cn.cnic.security.xiandao.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  WebMvcConfigurerAdapter
 *
 *
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .maxAge(3600);
    }

    /**
     * 过滤器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration ir = registry.addInterceptor(new VisitInterceptor());
//        //排除
//        ir.excludePathPatterns("/hello","/*.html");
//        ir.excludePathPatterns("/authentication");
//        ir.addPathPatterns("/**");
//    }

}
