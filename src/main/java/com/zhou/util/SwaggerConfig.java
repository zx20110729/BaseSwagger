package com.zhou.util;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Swagger插件类
 * Created by ZhouXiang on 2017/6/28 15:35.
 */
@Configuration
@EnableWebMvc //非常重要
@EnableSwagger
@ComponentScan(basePackages = {"com.zhou.controller"})
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?")
                .apiVersion("0.1")
                .swaggerGroup("user");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("BaseSwagger API文档"
                , "后台接口文档"
                , "My Apps API term of Service"
                , "751945866@qq.com"
                , "My Apps API license type"
                , "My Apps API license Url");
        return apiInfo;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
