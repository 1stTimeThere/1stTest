package com.newparse.jnews;

import com.newparse.jnews.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JnewsApplication {

//
	public static void main(String[] args) {
		SpringApplication.run(MainService.class, args);

	}

}
