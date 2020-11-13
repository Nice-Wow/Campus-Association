package com.cb.module.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.user.domain.SysAuth;
import com.cb.module.user.domain.SysRole;
import com.cb.module.user.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户Dao
 * 
 * @author CL
 *
 */
@Mapper
public interface SysUserRepository extends BaseMapper<SysUser> {

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
}
