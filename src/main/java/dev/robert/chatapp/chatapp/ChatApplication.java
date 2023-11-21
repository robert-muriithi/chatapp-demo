package dev.robert.chatapp.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("CHAT SERVICE RUNNING ON PORT: 3200 INITIALIZED SUCCESSFULLY AT " + new Date());
		};
	}

}
