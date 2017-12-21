package com.habuma.spitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;
import com.habuma.spitter.service.SpitterServiceImpl;

public class SpitterMain {

	public static void main(String[] args) {
		
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-servlet.xml");
		
        SpitterService spitterServiceImpl = (SpitterService) context.getBean("spitterServiceImpl");
		
		Spitter spitter = new Spitter();
		spitter.setUsername("yaha");
		spitter.setPassword("123456");
		spitter.setFullName("yaha ding");
		
		
		spitterServiceImpl.addSpitter(spitter);
	}
}
