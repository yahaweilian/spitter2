package com.habuma.spitter.service;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.util.EditSpitter;
import com.habuma.spitter.util.ShortSpitter;

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

	/**
	 * 获取所有用户
	 * @return
	 */
	List<ShortSpitter> getAllUsers();

	/**
	 * 根据条件查询
	 * @param query
	 * @return
	 */
	List<ShortSpitter> searchSpitters(String query);

	/**
	 * 根据username删除spitter
	 * @param username
	 */
	void deleteSpitter(String username);
	
	/**
	 * 根据用户名获取spitter
	 * @param username
	 * @return
	 */
	Spitter getSpitterByUsername(String username);
	
	void addSpitterToFollower(Spitter spitterMe, Spitter spitterToFollow);
	
	void removeSpitterFromFollowers(Spitter spitterMe, String username);
	
	boolean isSpitterFollowedBy(Spitter spitterMe, String username);
	
	void updateSpitter(EditSpitter editSpitter);
	
	List<ShortSpitter> getSpittersIFollow();
	
	List<ShortSpitter> getSpittersWhoFollowMe();
	
	int countFollowers();
	
	int countFollowing();
	
	void remindPassword(String username, String email);
	
	boolean confirmUserDetails(String username, String email);
	boolean isUsernameAvailable(String username);

	void setBeanFactory(BeanFactory context) throws BeansException;
}
