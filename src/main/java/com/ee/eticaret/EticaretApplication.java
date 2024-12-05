package com.ee.eticaret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EticaretApplication {

	public static void main(String[] args) {
		SpringApplication.run(EticaretApplication.class, args);
	}

}
