package com.cb.module.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.user.domain.SysAuth;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统权限Dao
 * 
 * @author CL
 *
 */
@Mapper
public interface SysAuthRepository extends BaseMapper<SysAuth> {

}
