package com.cb.module.user.handler;

import com.cb.module.common.JwtSecurityProperties;
import com.cb.module.common.utils.ResponseUtils;
import com.cb.module.user.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登出成功处理类
 * 
 * @author CL
 *
 */
@Slf4j
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		// 添加到黑名单
		String token = request.getHeader(JwtSecurityProperties.tokenHeader);
		JwtTokenUtils.addBlackList(token);

		log.info("用户{}登出成功，Token信息已保存到Redis的黑名单中", JwtTokenUtils.getUserNameByToken(token));

		SecurityContextHolder.clearContext();
		ResponseUtils.responseJson(response, ResponseUtils.response(200, "登出成功", null));
	}
}
