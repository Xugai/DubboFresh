package com.imooc.one.dubbo.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by rabbit on 2019/5/26.
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-dubbo.xml", "classpath:spring/spring-jdbc.xml"})
@MapperScan(basePackages = "com.imooc.one.dubbo.module.mapper")
public class BootMoreApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootMoreApplication.class);
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(BootMoreApplication.class, args);
    }
}
