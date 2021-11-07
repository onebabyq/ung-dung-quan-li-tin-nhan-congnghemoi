package com.example.ChatWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatWebApplication {
//	@Resource
//	FilesStorageService storageService;

	public static void main(String[] args) {
		// System.out.println("HELLO WORLD");
		SpringApplication.run(ChatWebApplication.class, args);
	}

//	@Override
//	public void run(String... arg) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
//	}
}
