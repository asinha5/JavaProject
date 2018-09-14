package com.target.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.target.service.ValidateService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.target.controller"})
public class TargetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetApplication.class, args);
	}
	
	 @Bean
	    public ValidateService validateService()
	    {
	    	return(new ValidateService());
	    }
}
