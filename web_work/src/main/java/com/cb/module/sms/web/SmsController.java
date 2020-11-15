package com.cb.module.sms.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.module.common.entity.AjaxResult;
import com.cb.module.common.utils.RegularExpressionUtils;
import com.cb.module.sms.service.SmsService;
import com.cb.module.user.domain.SysUser;
import com.cb.module.user.domain.SysUserDetails;
import com.cb.module.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LinJH
 * @Date: 2020/11/14 12:37
 * @Version:0.0.1
 */
@RestController
@Api(tags = "短信模块api")
@RequestMapping(value = "/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "发送登录用的短信验证码", notes = "")
    @GetMapping(value = "/send")
    public AjaxResult send(@RequestParam("phoneNum") String phoneNum) {
        System.out.println(phoneNum);
        if(!RegularExpressionUtils.check(RegularExpressionUtils.PHONE_PATTERN,phoneNum)){
            return AjaxResult.error("手机号格式错误");
        }
        return AjaxResult.success(smsService.getRandomCode(phoneNum));
    }
}
