package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;

/**
 * 
 * @author Administrator
 *
 */
public interface SpitterDao {

	/**
	 * ���spitter
	 * @param spitter
	 */
	void addSpitter(Spitter spitter);

	/**
	 * ��ȡ�����spittles
	 * @param pageNums
	 */
	Object getRecentSpittles(int pageNums);
}
