package com.zimug.dongbb.cloud.aservice.rbac.resttest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DiscoveryClientTest {
  @Resource
  private DiscoveryClient discoveryClient;  // 进行eureka的发现服务

  @Test
  void discoveryClientTest() {

    List<String> services = discoveryClient.getServices();
    services.forEach(System.out::println);

    for (String service:services){
      discoveryClient.getInstances(service)
              .forEach(s -> {
                System.out.println("InstanceId=" + s.getHost() + ":" + s.getPort());
                System.out.println("Host:Port="+ s.getHost() + ":" + s.getPort());
                System.out.println("Uri=" + s.getUri());
                System.out.println("InstanceId=" + s.getInstanceId());
                System.out.println("Schema=" + s.getScheme());
                System.out.println("ServiceId=" + s.getServiceId());
                System.out.println("Metadata="+ s.getMetadata());
              });
    }

  }

}
