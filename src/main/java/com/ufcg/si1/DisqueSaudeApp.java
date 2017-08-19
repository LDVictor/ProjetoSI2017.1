package com.ufcg.si1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.ufcg.si1"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class DisqueSaudeApp {

	public static void main(String[] args) {
		SpringApplication.run(DisqueSaudeApp.class, args);
	}
}