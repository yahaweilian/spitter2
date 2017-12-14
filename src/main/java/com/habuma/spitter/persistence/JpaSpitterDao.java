package com.habuma.spitter.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.spitter.domain.Spitter;

/**
 * JPA持久化使用的DAO
 * @author Administrator
 *
 */
@Repository("jpaSpitterDao")
@Transactional
public class JpaSpitterDao implements SpitterDao {

	private static final String RECENT_SPITTLES ="SELECT s FROM Spittle s";
	private static final String ALL_SPITTERS ="SELECT s FROM Spitter s";
	private static final String SPITTLER_FOR_USERNAME ="SELECT s FROM Spitter s WHERE s.username = :username";
	private static final String SPITTLES_BY_USERNAME ="SELECT s FROM Spittle s WHERE s.spitter.username = :username";
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addSpitter(Spitter spitter) {
		em.persist(spitter);
	}

	public Spitter getSpitterById(long id){
		return em.find(Spitter.class, id);
	}
	
	public void saveSpitter(Spitter spitter){
		em.merge(spitter);
	}

	@Override
	public Object getRecentSpittles(int pageNums) {
		// TODO Auto-generated method stub
		return null;
	}

}
