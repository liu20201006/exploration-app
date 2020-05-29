package com.aaa.liuhao.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 10:25
 * @Version
 * @Description //TODO
 */
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
}
