package com.habuma.spitter.service;

import java.util.List;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.util.Tuple;

public interface SpittleService {

	/**
	 * @param spittle
	 * @param spitter
	 */
	void addSpittle(Spittle spittle, Spitter spitter);
	
	/**
	 * @param spitterMe
	 * @return
	 */
	List<Tuple> getRecentSpittles(Spitter spitterMe);
	
	/**
	 * @param id
	 */
	void deleteSpittle(long id);

}
