package com.aaa.liuhao.controller;

import com.aaa.liuhao.base.BaseController;
import com.aaa.liuhao.base.ResultData;
import com.aaa.liuhao.model.Role;
import com.aaa.liuhao.service.IQYService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/22 10:17
 * @Version
 * @Description //TODO 角色
 */
@RestController
@Api(value = "角色管理", tags = "角色管理接口")
public class RoleController extends BaseController {
    @Autowired
    private IQYService qyService;

    /**
     * @Description:
     * 查询所有角色信息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/22 10:28
     */
    @PostMapping("/selectRole")
    @ApiOperation(value = "查询所有角色", notes = "查询所有角色功能")
    public ResultData selectRole() {
        List<Role> roles = qyService.selectRole();
        if (null!=roles&&"".equals(roles)){
            //说明查询成功
            return super.selectSuccess(roles);
        }else {
            //说明查询失败
            return super.selectFailed();
        }
    }
}


