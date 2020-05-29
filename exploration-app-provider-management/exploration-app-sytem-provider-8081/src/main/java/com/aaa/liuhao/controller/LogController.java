package com.aaa.liuhao.controller;

import com.aaa.liuhao.base.BaseSerivce;
import com.aaa.liuhao.base.CommonController;
import com.aaa.liuhao.base.ResultData;
import com.aaa.liuhao.model.LoginLog;
import com.aaa.liuhao.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/28 11:12
 * @Version
 * @Description //TODO
 */
@RestController
public class LogController extends CommonController<LoginLog>{
    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseSerivce<LoginLog> getBaseService() {
        return loginLogService;
    }
    /**
     * @Description:
     * 实现登录日志保存
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/28 11:14
     */
    @PostMapping("/addLoginLog")
    public ResultData addLoginLog(@RequestBody Map map) {
        return super.add(map);
    }
}
