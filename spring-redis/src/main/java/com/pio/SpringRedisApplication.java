package com.pio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class SpringRedisApplication {

	public static void main(String[] args) {

	//	SpringApplication.run(SpringRedisApplication.class, args);
		ApplicationContext context = (ApplicationContext) SpringApplication.run(SpringRedisApplication.class, args);
		System.out.println("Number of beans : " + context.getBeanDefinitionCount());

		for(String name : context.getBeanDefinitionNames())
		{
			System.out.println(name);
		}
	}

}
