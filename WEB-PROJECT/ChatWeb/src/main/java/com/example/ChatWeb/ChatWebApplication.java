package com.example.ChatWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ChatWebApplication {
	
	public static void main(String[] args) {
		//System.out.println("HELLO WORLD");
		SpringApplication.run(ChatWebApplication.class, args);
	}

}
