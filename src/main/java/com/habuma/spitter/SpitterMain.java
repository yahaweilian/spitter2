package com.habuma.spitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.HibernateSpitterDao;
import com.springinaction.knights.Knight;

public class SpitterMain {

	public static void main(String[] args) {
		
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-servlet.xml");
		
        HibernateSpitterDao hibernateSpitterDao = (HibernateSpitterDao) context.getBean("hibernateSpitterDao");
		
		Spitter spitter = new Spitter();
		spitter.setUsername("yaha");
		spitter.setPassword("123456");
		spitter.setFullName("yaha ding");
		hibernateSpitterDao.addSpitter(spitter);
	}
}
