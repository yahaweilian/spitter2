package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringidolMain {

	public static void main(String[] args) throws PerformanceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/springidol/spring-idol.xml");
		Performer kenny = (Performer) context.getBean("kenny");
		kenny.perform();
		
		Performer duke = (Performer) context.getBean("poeticDuke");
		duke.perform();
	}
}
