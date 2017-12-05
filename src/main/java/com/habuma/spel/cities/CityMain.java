package com.habuma.spel.cities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CityMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/habuma/spel/cities/cities.xml");
		Cities city = (Cities) context.getBean("city");
		System.out.println(city);
	}
}
