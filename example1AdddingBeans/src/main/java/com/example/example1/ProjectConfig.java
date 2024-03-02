package com.example.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.example.example1, com.example.domain")
public class ProjectConfig {
	@Bean
	@Primary
	public Integer myFavoriteNumber() {
		return 232;
	}
	@Bean(name = "96")
	public Integer yearIWasBorn() {
		return 96;
	}
}
