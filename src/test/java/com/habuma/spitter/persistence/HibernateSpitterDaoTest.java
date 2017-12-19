package com.habuma.spitter.persistence;
import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spitter.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-servlet.xml"})
public class HibernateSpitterDaoTest {

	@Autowired
	@Qualifier("hibernateSpitterDao")
	private HibernateSpitterDao hibernateSpitterDao ;
	

	@Test
	public void testHibernateSpitterDao() {
		assertNotNull(hibernateSpitterDao);
	}

	@Test
	public void testAddSpitter() {
		Spitter spitter = new Spitter();
		spitter.setUsername("yaha");
		spitter.setPassword("123456");
		spitter.setFullName("yaha ding");
		hibernateSpitterDao.addSpitter(spitter);
	}

}
