package com.springinaction.knights;

/**
 * @author Administrator
 * 少女营救骑士
 */
public class DamselRescuingKnight implements Knight {

	private RescueDamselQuest quest;
	
	public DamselRescuingKnight(){ //与 RscueDamselQuest 紧耦合，限制了这个骑士的能力，这个骑士只能营救少女
		quest = new RescueDamselQuest(); 
	}
	
	@Override
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}
}
