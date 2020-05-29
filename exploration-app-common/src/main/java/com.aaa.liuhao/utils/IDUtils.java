package com.aaa.liuhao.utils;

import java.util.UUID;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 13:39
 * @Version
 * @Description //TODO
 */
public class IDUtils {
    private IDUtils() {

    }

    /**
     * @Description:
     *  获取uuid
     * @author:Liu Hao
     * @param:[]
     * @return:java.lang.String
     * @exception:
     * @date:2020/5/18 13:39
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
