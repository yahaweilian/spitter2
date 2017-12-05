package com.springinaction.knights;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class BraveKnightTest {

	@Test
	public void testBraveKnight() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmbarkOnQuest() throws QuestException {
		Quest mockQuest = mock(Quest.class);

		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();

		verify(mockQuest, times(1)).embark();
	}

}
