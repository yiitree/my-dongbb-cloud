package com.zimug.dongbb.cloud.starter.web.config;


import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import com.zimug.dongbb.cloud.starter.web.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e) {
        return AjaxResponse.error(e);
    }
}