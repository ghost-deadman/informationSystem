package com.example.informationSystem.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 9:33
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域请求
     * @param registry 请求体
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //设置放行哪些原始域
                .allowedOriginPatterns("*")
                //放行哪些请求方式
                //.allowedMethods(new String[]{"GET", "POST"})
                .allowedMethods("*")
                //放行哪些原始请求头部信息
                .allowedHeaders("*")
                //暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }

}

