package com.springinaction.knights;

/**
 * @author Administrator
 * ��ŮӪ����ʿ
 */
public class DamselRescuingKnight implements Knight {

	private RescueDamselQuest quest;
	
	public DamselRescuingKnight(){ //�� RscueDamselQuest ����ϣ������������ʿ�������������ʿֻ��Ӫ����Ů
		quest = new RescueDamselQuest(); 
	}
	
	@Override
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}
}
