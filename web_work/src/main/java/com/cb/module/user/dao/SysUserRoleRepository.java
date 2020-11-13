package com.cb.module.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.user.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户角色Dao
 * 
 * @author CL
 *
 */
@Mapper
public interface SysUserRoleRepository extends BaseMapper<SysUserRole> {

}
