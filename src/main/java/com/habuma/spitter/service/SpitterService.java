package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;

/**
 * @author Administrator
 *
 */
public interface SpitterService {

	/**
	 * ���spitter
	 * @param spitter
	 */
	void addSpitter(Spitter spitter);
	
	/**
	 * ��ȡ�����spittles
	 * @param pageNums
	 */
	Object getRecentSpittles(int defaultSpittlesPerPage);

	/**
	 * �������ֻ�ȡspitter
	 * @param username
	 * @return
	 */
	Spitter getSpitter(String username);

	/**
	 * �������ֻ�ȡspittles
	 * @param username
	 * @return
	 */
	Object getSpittlesForSpitter(String username);
}
