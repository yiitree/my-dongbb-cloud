package com.zimug.dongbb.cloud.starter.web.config;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //return returnType.hasMethodAnnotation(ResponseBody.class);
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if(selectedContentType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)){
            if(body instanceof AjaxResponse){
                return body;
            }else{
                // 全局异常处理的时候，把自定义返回的code也添加进去
                AjaxResponse ajaxResponse = AjaxResponse.success(body);
                response.setStatusCode(HttpStatus.valueOf(
                        ajaxResponse.getCode())
                );
                return AjaxResponse.success(body);
            }
        }
        return body;
    }
}
