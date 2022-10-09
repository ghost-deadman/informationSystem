package com.example.informationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下的controller生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.example.informationSystem.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }
    private ApiInfo apiInfo() {
        //设置文档信息
        return new ApiInfoBuilder()
                .title("项目信息管理系统文档")
                .description("项目信息管理系统接口文档")
                .contact(new Contact("zzx", "http:localhost:8080/doc.html",
                        "3065939264@qq.com"))
                .version("1.0")
                .build();
    }


    private List<SecurityContext> securityContexts() {
        List<SecurityContext> res = new ArrayList<>();
        // 设置需要登录认证的路径
        res.add(getContextByPath("/user/logout"));
        res.add(getContextByPath("/hello"));
        res.add(getContextByPath("/test"));
        return res;
    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder().securityReferences(defaultAuthPath())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuthPath() {
        List<SecurityReference> res = new ArrayList<>();
        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = scope;
        res.add(new SecurityReference("Authorization",scopes));
        return res;
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> res = new ArrayList<>();
        // 设置请求头信息
        ApiKey apiKey = new ApiKey("Auth", "token", "Header");
        res.add(apiKey);
        return res;
    }


    /**
     * 解决swagger在springboot2.7以后的空指针异常
     */
    /*
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }
            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null).collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }
            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    assert field != null;
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }*/
}