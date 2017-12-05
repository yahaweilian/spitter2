package com.springinaction.knights;


/**
 * 勇敢骑士
 * @author Administrator
 *
 */
public class BraveKnight implements Knight {

	private Quest quest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;// 构造器注入 quest  ，解耦 ，勇敢骑士可以回应任何的请求
	}
	
	@Override
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	
}
