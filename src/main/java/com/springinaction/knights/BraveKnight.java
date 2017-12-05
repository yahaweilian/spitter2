package com.springinaction.knights;


/**
 * �¸���ʿ
 * @author Administrator
 *
 */
public class BraveKnight implements Knight {

	private Quest quest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;// ������ע�� quest  ������ ���¸���ʿ���Ի�Ӧ�κε�����
	}
	
	@Override
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	
}
