package com.aaa.liuhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 10:10
 * @Version
 * @Description //TODO
 *  也可以使用@SpringCloudApplication(新注解)，代替
 *  *         @SpringBootApplication, @EnableDiscoveryClient, @EnableCircuitBreaker
 */
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@MapperScan("com.aaa.liuhao.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class,args);
    }
}
