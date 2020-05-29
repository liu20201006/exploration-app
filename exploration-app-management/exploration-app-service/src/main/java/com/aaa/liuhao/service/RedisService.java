package com.aaa.liuhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 8:38
 * @Version
 * @Description //TODO
 */
@Service
public class RedisService {
    @Autowired
    private JedisCluster jedisCluster;
}
