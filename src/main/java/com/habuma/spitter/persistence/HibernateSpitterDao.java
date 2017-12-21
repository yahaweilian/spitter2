package com.habuma.spitter.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

/**
 * Hibernate DAO
 * @author Administrator
 *
 */
@Primary
@Repository("hibernateSpitterDao")
public class HibernateSpitterDao implements SpitterDao {

	private SessionFactory sessionFactory;
	
//	private HibernateTemplate hibernateTemplate ;
	
	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
//		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	
	/**
	 * getCurrentSession所有操作都必须放在事务中 ,否则会产生异常
	 * @return
	 */
	private Session currentSession(){
//		return hibernateTemplate.getSessionFactory().getCurrentSession();
		return sessionFactory.openSession();
	}

	@Override
	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}

	@Override
	public void updateSpitter(Spitter spitter){
		currentSession().update(spitter);
	}
	
	public Spitter getSpitterById(long id){
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	@Override
	public List<Spittle> getRecentSpittles(int pageNums) {
		
		return currentSession().createCriteria(Spittle.class).setMaxResults(pageNums).list();
	}


	@Override
	public Spitter getSpitterByName(String username) {
		Query query = currentSession().createQuery("from Spitter where username = :username");
		query.setString("username", username);
		@SuppressWarnings("unchecked")
		List<Spitter> users = query.list();
		if(users.size() != 0) {
			return users.get(0);
		} 
		return null;
	}




}
