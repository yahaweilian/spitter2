package com.habuma.spitter.persistence;
import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.habuma.spitter.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-servlet.xml"})
@EnableWebMvc
public class HibernateSpitterDaoTest {

	@Autowired
	@Qualifier("hibernateSpitterDao")
	public HibernateSpitterDao hibernateSpitterDao ;


	@Test
	public void testHibernateSpitterDao() {
		assertNotNull(hibernateSpitterDao);
	}

	@Test
	public void testAddSpitter() {
		Spitter spitter = new Spitter();
		spitter.setUsername("yH1");
		spitter.setPassword("123456");
		spitter.setFullName("yaha ding");
//		spitter.setId(1);
		hibernateSpitterDao.addSpitter(spitter);
	}

	@Test
	public void testGetSpitterById(){
		Spitter spitter = hibernateSpitterDao.getSpitterById(1);
		assertNotNull(spitter);
		System.out.println(spitter.getId());
	}
}
