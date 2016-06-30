package com.beyond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	//启动spring boot的入口
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
