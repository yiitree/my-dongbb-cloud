package com.zimug.dongbb.cloud.aservice.rbac.feign;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import com.zimug.dongbb.cloud.starter.web.exception.CustomExceptionType;
import org.springframework.stereotype.Component;

@Component
public class SmsServiceFallback implements SmsService {

   @Override
   public AjaxResponse send(String phoneNo, String content) {
      return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR
                  ,"短信发送接口失败!");
   }
}