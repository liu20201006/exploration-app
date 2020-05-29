package com.aaa.liuhao.controller;

import com.aaa.liuhao.base.ResultData;
import com.aaa.liuhao.mapper.UserMapper;
import com.aaa.liuhao.model.User;
import com.aaa.liuhao.redis.RedisService;
import com.aaa.liuhao.service.LoginService;
import com.aaa.liuhao.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/18 13:25
 * @Version
 * @Description //TODO
 */
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;

    /**
     * 执行登录操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody User user) {
        return loginService.doLogin(user, redisService);
    }
}
