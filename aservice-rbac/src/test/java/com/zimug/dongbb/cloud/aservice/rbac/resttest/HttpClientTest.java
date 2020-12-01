package com.zimug.dongbb.cloud.aservice.rbac.resttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class HttpClientTest {

  @Test
  void httpPost() throws Exception {
    //发送远程的http请求的地址
    String url = "http://localhost:8402/sms/send";
    //创建HttpClient对象
    CloseableHttpClient client = HttpClients.createDefault();
    //创建HttpPost对象, 发送post请求
    HttpPost method = new HttpPost(url);
    //封装发送到服务提供者的参数
    NameValuePair phoneNo = new BasicNameValuePair("phoneNo", "13214409773");
    NameValuePair content = new BasicNameValuePair("content", "HttpClient测试远程服务调用");
    List<NameValuePair> params = new ArrayList<>();
    params.add(phoneNo);
    params.add(content);
    //封装请求体数据
    method.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
    //发送具体的http请求
    HttpResponse response = client.execute(method);

    //获得服务提供者响应的具体数据
    HttpEntity entity = response.getEntity();

    //获得http的响应体
    InputStream is = entity.getContent();
    int len = 0;
    char[] buf = new char[1024];
    //使用字符流读
    InputStreamReader reader = new InputStreamReader(is);
    StringBuffer sb = new StringBuffer();
    while((len = reader.read(buf)) != -1){
      sb.append(String.valueOf(buf, 0, len));
    }

    //转成对象
    ObjectMapper mapper = new ObjectMapper();
    AjaxResponse ajaxResponse = mapper.readValue(sb.toString(), AjaxResponse.class);
    System.out.println(ajaxResponse);

  }

}
