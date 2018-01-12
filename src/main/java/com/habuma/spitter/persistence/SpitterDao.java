package com.habuma.spitter.persistence;

import java.util.Collection;
import java.util.List;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.util.EditSpitter;
import com.habuma.spitter.util.ShortSpitter;
import com.habuma.spitter.util.Tuple;

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

	void saveSpitter(Spitter spitter);
	
	Spitter findSpitterByUserameOrEmail(String usernameOrEmail);
	
	void addSpittle(Spittle spittle);
	
	Collection<Tuple> getRecentSpittles(long id);
	
	void updateSpitter(String username, EditSpitter editSpitter, String avatarAction);
	
	List<ShortSpitter> getFollowing(String username);
	
	List<ShortSpitter> getFollowers(String username);
	
	int countFollowers(String username);
	
	int countFollowing(String username);
	
	List<ShortSpitter> searchSpitters(String query);
	
	void deleteSpittle(String username, long id);
	
	boolean confirmUserDetails(String username, String email);
	
	boolean updateSpitterPassword(String username, String password);
	
	List<ShortSpitter> getAllUsers();
	
	void deleteSpitter(String username);
	
	boolean isUsernameAvailable(String username);
}
