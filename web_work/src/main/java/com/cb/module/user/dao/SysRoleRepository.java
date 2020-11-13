package com.cb.module.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.user.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色Dao
 * 
 * @author CL
 *
 */
@Mapper
public interface SysRoleRepository extends BaseMapper<SysRole> {

}
