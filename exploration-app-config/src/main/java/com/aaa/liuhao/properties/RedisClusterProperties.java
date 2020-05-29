package com.aaa.liuhao.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 8:26
 * @Version
 * @Description //TODO
 *   @PropertySource这个注解的作用是加载某一个properties文件中属性的值
 */
@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {
    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
