package com.habuma.spitter.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpitterDao;

/**
 * @author Administrator
 *
 */
@Service("spitterServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpitterServiceImpl implements SpitterService {
	
	private SpitterDao hibernateSpitterDao;
	
	@Autowired
	public SpitterServiceImpl(SpitterDao hibernateSpitterDao) {
		this.hibernateSpitterDao = hibernateSpitterDao;
	}

	/*
	 * 传播行为被设置为REQUIRED，要求必须在事务中运行
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addSpitter(Spitter spitter) {
		hibernateSpitterDao.addSpitter(spitter);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Spittle> getRecentSpittles(int defaultSpittlesPerPage) {
		return (List<Spittle>) hibernateSpitterDao.getRecentSpittles(defaultSpittlesPerPage);
	}

	@Override
	public Spitter getSpitter(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSpittlesForSpitter(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
