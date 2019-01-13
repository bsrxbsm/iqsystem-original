package com.gluxen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.gluxen.dao")
public class IqSystemApplication extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
				.allowCredentials(true).maxAge(3600);
	}




	public static void main(String[] args) {
		SpringApplication.run(IqSystemApplication.class, args);
	}
}
