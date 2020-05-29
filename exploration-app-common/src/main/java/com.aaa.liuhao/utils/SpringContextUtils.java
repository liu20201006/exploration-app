package com.aaa.liuhao.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 10:33
 * @Version
 * @Description 获取Spring的容器工具类
 */
public class SpringContextUtils implements ApplicationContextAware{

    private SpringContextUtils() {

    }

    private static ApplicationContext APPLICATIONCONTEXT = null;
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    /*@Override*/
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATIONCONTEXT = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        Lock lock = READ_WRITE_LOCK.readLock();
        lock.lock();
        try {
            if(null != APPLICATIONCONTEXT) {
                return APPLICATIONCONTEXT;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }


}
