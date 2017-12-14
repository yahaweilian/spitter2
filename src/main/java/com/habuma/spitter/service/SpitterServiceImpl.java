package com.habuma.spitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.SpitterDao;

/**
 * @author Administrator
 *
 */
@Service("spitterServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class SpitterServiceImpl implements SpitterService {
	
	private SpitterDao hibernateSpitterDao;

	@Autowired
	public SpitterServiceImpl(SpitterDao hibernateSpitterDao) {
		this.hibernateSpitterDao = hibernateSpitterDao;
	}

	/* (non-Javadoc)
	 * @see com.habuma.spitter.service.SpitterService#addSpitter(com.habuma.spitter.domain.Spitter)
	 * 传播行为被设置为REQUIRED，要求必须在事务中运行
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public void addSpitter(Spitter spitter) {
		hibernateSpitterDao.addSpitter(spitter);
	}

	@Override
	public Object getRecentSpittles(int defaultSpittlesPerPage) {
		return hibernateSpitterDao.getRecentSpittles(defaultSpittlesPerPage);
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
