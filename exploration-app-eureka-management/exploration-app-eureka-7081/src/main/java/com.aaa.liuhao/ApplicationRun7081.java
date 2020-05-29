package com.aaa.liuhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 8:48
 * @Version
 * @Description //TODO
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class,args);
    }
}
