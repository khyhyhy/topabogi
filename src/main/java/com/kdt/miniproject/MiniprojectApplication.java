package com.kdt.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}

 @Bean
public CharacterEncodingFilter characterEncodingFilter() {
	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);
    return characterEncodingFilter;

}
}
