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

	/**
	 * 更新spitter
	 * @param spitter
	 */
	void updateSpitter(Spitter spitter);

	/**
	 * 通过名字获取Spitter
	 * @param username
	 * @return
	 */
	Spitter getSpitterByName(String username);
}
