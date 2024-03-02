package com.exampleRestApplication.Example.Rest.Application.controller;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.exampleRestApplication.Example.Rest.Application.proxies")
public class ProjectConfig {

}
