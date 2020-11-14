package com.cb.module.sms.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cb.module.common.redis.template.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 发短信工具类
 * @Author: LinJH
 * @Date: 2020/11/13 23:29
 * @Version:0.0.1
 */
public class MessageUtils {
    @Autowired
    RedisRepository redisUtils;

    public static void messagePost(String u_phone, String message){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GFkznLkD6AeFAsqiAuZ", "RUFgg32qcibGrLLi8r1ADoTaJGQxWB");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",u_phone);
        request.putQueryParameter("SignName", "软工项目闲置网站");
        request.putQueryParameter("TemplateCode", "SMS_205457031");
        request.putQueryParameter("TemplateParam", "{\"code\":"+message+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
