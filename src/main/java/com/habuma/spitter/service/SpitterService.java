package com.habuma.spitter.service;

import java.util.List;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

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
	List<Spittle> getRecentSpittles(int defaultSpittlesPerPage);

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

	
	/**
	 * 更新 spitter
	 * @param spitter
	 */
	void savaSpitter(Spitter spitter);
}
