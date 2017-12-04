package com.springinaction.knights;

/**
 * @author Administrator
 * 营救少女请求
 */
public class RescueDamselQuest implements Quest{

	/**
	 * 行动
	 * @throws QuestException
	 */
	public void embark() throws QuestException{
		System.out.println("营救少女");
	}

}
