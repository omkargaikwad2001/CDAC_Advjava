package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Language;
import com.entity.Trainer;

@Configuration
public class MyBean {

//    @Bean
//    public Language getLanguageBean() {
//        return new Language("Adv Java");
//    }
//
//    @Bean
//    public Trainer getTrainerBean(Language lang) {
//        return new Trainer(lang);
//    }
	
	@Bean
	public Trainer getTrainerBean() {
		
		Language lang = new Language("ADV JAVA");
		
		Trainer t = new Trainer(lang);
		
		return t;
	}
}
