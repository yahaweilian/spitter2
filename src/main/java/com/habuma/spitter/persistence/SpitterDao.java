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
	 * 获取最近的spittles
	 * @param pageNums
	 */
	Object getRecentSpittles(int pageNums);
}
