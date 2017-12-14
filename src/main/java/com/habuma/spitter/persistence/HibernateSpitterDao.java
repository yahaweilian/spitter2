package com.habuma.spitter.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.habuma.spitter.domain.Spitter;

/**
 * Hibernate DAO
 * @author Administrator
 *
 */
@Repository
public class HibernateSpitterDao implements SpitterDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}

	public void updateSpitter(Spitter spitter){
		currentSession().update(spitter);
	}
	
	public Spitter getSpitterById(long id){
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	@Override
	public Object getRecentSpittles(int pageNums) {
		// TODO Auto-generated method stub
		return null;
	}

}
