package com.newparse.jnews;

import org.springframework.boot.CommandLineRunner;
import com.newparse.jnews.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class JnewsApplication implements CommandLineRunner{
	@Autowired
	MainService mainService;
	public static void main(String[] args) {
		SpringApplication.run(JnewsApplication.class, args);
	}

	@Override
	public void run(String... args){
		mainService.execute();
	}
}
