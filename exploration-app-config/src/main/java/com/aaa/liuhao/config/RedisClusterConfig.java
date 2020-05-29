package com.aaa.liuhao.config;

import com.aaa.liuhao.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 8:25
 * @Version
 * @Description //TODO
 */
@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    /**
     * @Description:
     *  注入redis为java所提供的API(jedisCluster)
     * @author:Liu Hao
     * @param:[]
     * @return:redis.clients.jedis.JedisCluster
     * @exception:
     * @date:2020/5/18 8:28
     */
    @Bean
    public JedisCluster getJedisCluster() {
        // 1.获取redis的IP地址以及端口号信息(192.168.23.166:6380,192.168.23.166:6381...6385)
        String nodes = redisClusterProperties.getNodes();
        // 2.分割nodes，分割成一个一个的ip:端口号的格式
        String[] nodeArr = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        // 3.循环分割后的数据
        for(String node : nodeArr) {
            // 4.再次分割，把ip地址和端口号分离(以":"为分隔符)
            String[] hostPort = node.split(":");
            // 5.创建redis所需要的HostAndPort对象
            HostAndPort hostAndPort = new HostAndPort(hostPort[0], Integer.parseInt(hostPort[1]));
            // 6.把HostAndPort对象存入到hostAndPortSet集合中
            hostAndPortSet.add(hostAndPort);
        }
        // 7.创建JedisCluster对象
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
        // 8.返回JedisCluster对象
        return jedisCluster;
    }
}
