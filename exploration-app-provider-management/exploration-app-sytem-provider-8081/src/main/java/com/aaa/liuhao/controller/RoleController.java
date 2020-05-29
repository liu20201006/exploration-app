package com.aaa.liuhao.controller;

import com.aaa.liuhao.model.Role;
import com.aaa.liuhao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/22 10:08
 * @Version
 * @Description //TODO 角色
 */
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/selectRole")
    public List<Role> doLogin() {
        return roleService.seleceRole();
    }

}
