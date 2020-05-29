package com.aaa.liuhao.service;

import com.aaa.liuhao.base.BaseSerivce;
import com.aaa.liuhao.mapper.RoleMapper;
import com.aaa.liuhao.model.Role;
import com.aaa.liuhao.model.User;
import com.aaa.liuhao.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Company
 * 角色
 * @Author liuhao
 * @Date 2020/5/22 9:42
 * @Version
 * @Description //TODO
 */
public class RoleService extends BaseSerivce<Role> {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * @Description:
     * 查询所有用户信息
     * @author:Liu Hao
     * @param:[user, redisService]
     * @return:com.aaa.liuhao.vo.TokenVo
     * @exception:
     * @date:2020/5/22 9:49
     */
    public List<Role> seleceRole() {
        //查找用户信息
        List<Role> roles = roleMapper.selectAll();
        if (null!=roles&&"".equals(roles)){
            //说明查询成功
            return roles;
        }else {
            //说明查询失败
            return null;
        }

    }


}
