package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;

/**
 * 
 * @author Administrator
 *
 */
public interface SpitterDao {

	/**
	 * 添加spitter
	 * @param spitter
	 */
	void addSpitter(Spitter spitter);

	/**
	 * 查询spittles
	 * @param pageNums
	 */
	Object getRecentSpittles(int pageNums);
}
