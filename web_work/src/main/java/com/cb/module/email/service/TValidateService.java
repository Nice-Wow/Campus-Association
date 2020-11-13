package com.cb.module.email.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.module.email.domain.TValidate;
import com.cb.module.user.domain.SysUser;

import javax.mail.internet.MimeMessage;

/**
 * @Author: LinJH
 * @Date: 2020/11/8 10:29
 * @Version:0.0.1
 */
public interface TValidateService extends IService<TValidate> {

    public void sendPasswordResetEmail(MimeMessage email);

    public int insertNewResetRecord(TValidate tValidate, SysUser sysUser, String token);

    public TValidate findUserByResetToken(String token);

    public boolean sendValidateLimitation(String email, long requestPerDay, long interval);

    public boolean validateLimitation(String email, long requestPerDay, long interval, String token);

}
