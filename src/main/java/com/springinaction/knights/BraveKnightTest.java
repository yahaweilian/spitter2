package com.springinaction.knights;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;



public class BraveKnightTest extends TestCase {

	public void testBraveKnight() {
		fail("Not yet implemented");
	}

	public void testEmbarkOnQuest() throws QuestException {
		
		Quest mockQuest = mock(Quest.class);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		
		verify(mockQuest, times(1)).embark();
		
	}

}
