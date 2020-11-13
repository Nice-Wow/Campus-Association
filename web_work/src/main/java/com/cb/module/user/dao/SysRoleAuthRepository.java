package com.cb.module.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.user.domain.SysRoleAuth;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色权限Dao
 * 
 * @author CL
 *
 */
@Mapper
public interface SysRoleAuthRepository extends BaseMapper<SysRoleAuth> {

}
