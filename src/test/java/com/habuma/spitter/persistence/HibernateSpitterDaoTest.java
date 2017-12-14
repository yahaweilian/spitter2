package com.habuma.spitter.persistence;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.habuma.spitter.domain.Spitter;

public class HibernateSpitterDaoTest {

	
	HibernateSpitterDao hibernateSpitterDao;
	@Autowired
	public void setHibernateSpitterDao(HibernateSpitterDao hibernateSpitterDao) {
		this.hibernateSpitterDao = hibernateSpitterDao;
	}

	@Test
	public void testHibernateSpitterDao() {
		fail("Not yet implemented");
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
