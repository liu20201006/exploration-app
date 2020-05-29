package com.aaa.liuhao.controller;

import com.aaa.liuhao.annotation.LoginLogAnnotation;
import com.aaa.liuhao.base.BaseController;
import com.aaa.liuhao.base.ResultData;
import com.aaa.liuhao.model.User;
import com.aaa.liuhao.service.IQYService;
import com.aaa.liuhao.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 12:56
 * @Version
 * @Description //TODO
 */
@RestController
@Api(value = "登录信息", tags = "用户登录接口")
public class LoginController extends BaseController{
    @Autowired
    private IQYService qyService;

   /**
    * @Description:
    * 执行登录操作
    * @author:Liu Hao
    * @param:[user]
    * @return:com.aaa.liuhao.base.ResultData
    * @exception:
    * @date:2020/5/18 13:03
    */
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录功能", notes = "用户执行登录功能")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "管理员登录")
    public ResultData doLogin(User user) {
        TokenVo tokenVo = qyService.doLogin(user);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }
}
