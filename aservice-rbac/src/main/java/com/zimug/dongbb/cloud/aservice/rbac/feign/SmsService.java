package com.zimug.dongbb.cloud.aservice.rbac.feign;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ASERVICE-SMS")
public interface SmsService {

  @PostMapping(value = "/sms/send")
  AjaxResponse send(@RequestParam("phoneNo") String phoneNo,
                    @RequestParam("content") String content);

}
