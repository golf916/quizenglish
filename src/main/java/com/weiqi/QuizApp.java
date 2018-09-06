package com.weiqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.weiqi.mapper")
public class QuizApp {

	public static void main(String[] args) {
		SpringApplication.run(QuizApp.class, args);

	}

}
