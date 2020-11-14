package com.cb.module.user.filter;

import com.alibaba.druid.util.StringUtils;
import com.cb.module.common.redis.template.RedisRepository;
import com.cb.module.common.utils.RegularExpressionUtils;
import com.cb.module.common.utils.ResponseUtils;
import com.cb.module.sms.service.SmsService;
import com.cb.module.user.domain.SysUser;
import com.cb.module.user.service.SysUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: LinJH
 * @Date: 2020/11/2 23:56
 * @Version:0.0.1
 */
@Slf4j
public class MyJsonAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(!StringUtils.equalsIgnoreCase("POST",request.getMethod()) || !request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            ResponseUtils.responseJson(response, ResponseUtils.response(500, "必须是post请求方式和json数据格式",null));
            return null;
        }
        String username = null;
        String password = null;
        String code = null;
        try {
            Map<String,String> map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            username = map.get("username") == null ? map.get("phoneNum") : map.get("username");
            password = map.get("password");
            code = map.get("code");
            if(StringUtils.isEmpty(username)){
                ResponseUtils.responseJson(response, ResponseUtils.response(500, "用户名或手机不能为空",null));
            }
            if(StringUtils.isEmpty(password) && map.get("username") != null){
                ResponseUtils.responseJson(response, ResponseUtils.response(500, "密码不能为空", null));
            }
            if(StringUtils.isEmpty(code) && map.get("phoneNum") != null){
                ResponseUtils.responseJson(response,ResponseUtils.response(500,"短信验证码不能为空",null));
            }

            if(!RegularExpressionUtils.check(RegularExpressionUtils.USERNAME_PATTERN,username) && !RegularExpressionUtils.check(RegularExpressionUtils.PHONE_PATTERN,username)){
                ResponseUtils.responseJson(response, ResponseUtils.response(500, "用户名或手机输入格式不合法", null));
            }

            if(map.get("username") != null && !RegularExpressionUtils.check(RegularExpressionUtils.PASSWORD_PATTERN,password)){
                ResponseUtils.responseJson(response, ResponseUtils.response(500, "密码输入格式不合法", null));
            }

            if(RegularExpressionUtils.check(RegularExpressionUtils.PHONE_PATTERN,username)){
                String verifyCode = String.valueOf(RedisRepository.get(username));
                System.err.println(verifyCode);
                if(verifyCode == null || "null".equals(verifyCode)){
                    ResponseUtils.responseJson(response, ResponseUtils.response(500, "短信验证码已过期，请重新发送!", null));
                }

                if(!StringUtils.equals(code,verifyCode)){
                    ResponseUtils.responseJson(response, ResponseUtils.response(500, "短信验证码错误", null));
                }
                SysUser sysUser = sysUserService.findUserByPhoneOrUsername(username);
                if(sysUser != null){
                    password = sysUser.getPassword();
                }else{
                    password = "";
                }
            }

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
            setDetails(request,token);
            return this.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.attemptAuthentication(request, response);
    }

}
