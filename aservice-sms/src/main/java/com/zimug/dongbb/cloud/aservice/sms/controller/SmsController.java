package com.zimug.dongbb.cloud.aservice.sms.controller;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import com.zimug.dongbb.cloud.starter.web.exception.CustomException;
import com.zimug.dongbb.cloud.starter.web.exception.CustomExceptionType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    /**
     * 模拟短信发送
     * @param phoneNo
     * @param content
     * @return 短信发送结果
     */
    @PostMapping(value = "/send")
    public AjaxResponse send(@RequestParam String phoneNo,
                             @RequestParam String content) {
        if(content.isEmpty() || phoneNo.isEmpty()){
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "消息内容或手机号不能为空！");
        }
        System.out.println("发送短消息:" + content);

        return AjaxResponse.success("短消息发送成功！");
    }
}
