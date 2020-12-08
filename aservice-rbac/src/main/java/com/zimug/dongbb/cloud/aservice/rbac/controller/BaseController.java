package com.zimug.dongbb.cloud.aservice.rbac.controller;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import com.zimug.dongbb.cloud.starter.web.exception.CustomExceptionType;

/**
 * 通用controller把都有的方法放在这里面
 * 比如全局的回退方法，因为每个controller都有，所以可以直接定义在这里，之后每个controller继承这个类即可
 */
public class BaseController {

    //通用hystrix回退方法
    public AjaxResponse commonFallbackMethod() {
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR,
                "系统繁忙，请稍后再试!");
    }

}
