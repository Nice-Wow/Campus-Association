package com.cb.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.module.common.entity.AjaxResult;
import com.cb.module.user.domain.SysAuth;
import com.cb.module.user.domain.SysRole;
import com.cb.module.user.domain.SysUser;


import java.util.List;

/**
 * 系统用户service
 * @Author: LinJH
 * @Date: 2020/11/2 21:47
 * @Version:0.0.1
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名称查询用户信息
     *
     * @param username 用户名称
     * @return
     */
    SysUser findUserByUserName(String username);


    /**
     * 根据用户名或电话号码查询用户信息
     *
     * @param username 邮箱或用户名
     * @return
     */
    SysUser findUserByPhoneOrUsername(String username);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return
     */
    List<SysRole> findRoleByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return
     */
    List<SysAuth> findAuthByUserId(Long userId);

    /**
     * 注册新用户
     * @param sysUser
     */
    public AjaxResult registerUser(SysUser sysUser);
}
