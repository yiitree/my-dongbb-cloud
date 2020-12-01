package com.zimug.dongbb.cloud.aservice.rbac.resttest;

import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 使用restTemplate必须是spring环境，先进行配置，ContextConfig
 */
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)  //Junit5
@SpringBootTest
public class RestTemplateTest {

    // 可以选择其中一种实现方式
//  @Resource(name = "OKHttp3")
  @Resource
  private RestTemplate restTemplate;

  @Test
  void httpPostForObject() throws Exception {
    //发送远程http请求的url
//    String url = "http://localhost:8402/sms/send";
      // 添加负载均衡后，要使用服务名进行调用
    String url = "http://ASERVICE-SMS/sms/send";
    //发送到远程服务的参数
    MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
    params.add("phoneNo", "13214409773");
    params.add("content", "HttpClient测试远程服务调用");

    //通过RestTemplate对象发送post请求
    AjaxResponse ajaxResponse = restTemplate.postForObject(url, params, AjaxResponse.class);

    System.out.println(ajaxResponse);
  }

  @Test
  void httpPostForEntity() throws Exception {
    //发送远程http请求的url
    String url = "http://localhost:8402/sms/send";
    //发送到远程服务的参数
    MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
    params.add("phoneNo", "13214409773");
    params.add("content", "HttpClient测试远程服务调用");

    //通过RestTemplate对象发送post请求
    ResponseEntity<AjaxResponse> entitys = restTemplate.postForEntity(url, params, AjaxResponse.class);

    System.out.println(entitys.getBody());

    //查看响应的状态码
    System.out.println(entitys.getStatusCodeValue());

    //查看响应头
    HttpHeaders headMap = entitys.getHeaders();
    for(Map.Entry<String, List<String>> m : headMap.entrySet()){
      System.out.println(m.getKey() + ": " + m.getValue());
    }
  }


}
