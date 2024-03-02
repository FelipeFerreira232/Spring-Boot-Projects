package com.example.example2UsingAbstractions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"services", "proxies", "repositories", "aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
	
	
}
