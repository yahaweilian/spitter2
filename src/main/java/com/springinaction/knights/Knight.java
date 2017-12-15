package com.springinaction.knights;

/**
 * 骑士
 * @author Administrator
 *
 */
public interface Knight {
    
	/**
	 * 回应请求
	 */
	void embarkOnQuest() throws QuestException;
}
