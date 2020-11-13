package com.cb.module.sms.service.impl;

import com.cb.module.common.redis.template.RedisRepository;
import com.cb.module.sms.service.SmsService;
import com.cb.module.sms.utils.MessageUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LinJH
 * @Date: 2020/11/13 23:34
 * @Version:0.0.1
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public String getRandomCode(String phoneNum) {
        String authcode = "1"+ RandomStringUtils.randomNumeric(5);//生成随机数,我发现生成5位随机数时，如果开头为0，发送的短信只有4位，这里开头加个1，保证短信的正确性
        redisRepository.set(phoneNum,authcode,300);//将验证码存入缓存
        MessageUtils.messagePost(phoneNum,authcode);//发送短息
        return authcode;
    }
}
