package com.springinaction.knights;

/**
 * 屠龙请求
 * @author Administrator
 *
 */
public class SlayDragonQuest implements Quest {

	@Override
	public void embark() throws QuestException {
		System.out.println("屠龙");

	}

}
