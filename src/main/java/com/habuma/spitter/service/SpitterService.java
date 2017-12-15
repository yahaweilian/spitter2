package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;

/**
 * @author Administrator
 *
 */
public interface SpitterService {

	/**
	 * 添加spitter
	 * @param spitter
	 */
	void addSpitter(Spitter spitter);
	
	/**
	 * 获取最近的spittles
	 * @param pageNums
	 */
	Object getRecentSpittles(int defaultSpittlesPerPage);

	/**
	 * 根据名字获取spitter
	 * @param username
	 * @return
	 */
	Spitter getSpitter(String username);

	/**
	 * 根据名字获取spittles
	 * @param username
	 * @return
	 */
	Object getSpittlesForSpitter(String username);
}
