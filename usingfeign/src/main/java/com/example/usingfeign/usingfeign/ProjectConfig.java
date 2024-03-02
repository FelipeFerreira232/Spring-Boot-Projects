package com.example.usingfeign.usingfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.usingfeign.usingfeign.proxies")
public class ProjectConfig {

}
