package com.cb.module.user.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统权限
 * 
 * @author CL
 *
 */
@Data
@TableName("sys_auth")
public class SysAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 权限ID
	 */
	@TableId
	private Long id;

	/**
	 * 权限名称
	 */
	private String name;

	/**
	 * 权限标识
	 */
	private String permission;

}
