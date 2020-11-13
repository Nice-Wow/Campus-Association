package com.cb.module.sms.service;

/**
 * @Author: LinJH
 * @Date: 2020/11/13 23:33
 * @Version:0.0.1
 */
public interface SmsService {

    /**
     *
     * @param phoneNum
     * @return
     */
    public String getRandomCode(String phoneNum);
}
