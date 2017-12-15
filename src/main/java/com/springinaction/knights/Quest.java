package com.springinaction.knights;

/**
 * 请求
 * @author Administrator
 *
 */
public interface Quest {

	/**
	 * 行动
	 */
	void embark() throws QuestException;

}
