package com.habuma.spitter.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.HibernateSpitterDao;
import com.habuma.spitter.persistence.SpitterDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-servlet.xml"})
@EnableWebMvc
public class SpitterServiceImplTest {

	@Autowired
	@Qualifier("spitterServiceImpl")
	public SpitterServiceImpl spitterServiceImpl;
	
	@Test
	public void testAddSpitter() {
		
		Spitter spitter = new Spitter();
		spitter.setUsername("yH1");
		spitter.setPassword("123456");
		spitter.setFullName("yaha ding");
		spitterServiceImpl.addSpitter(spitter);
	}

}
