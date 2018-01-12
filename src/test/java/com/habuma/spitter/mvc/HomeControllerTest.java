package com.habuma.spitter.mvc;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.ui.Model;

import com.habuma.spitter.controller.HomeController;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;


public class HomeControllerTest {

	@Test
	public void shouldDisplayRencentSpittles() {
		List<Spittle> expectedSpittles = asList(new Spittle(),new Spittle(),new Spittle());
		
		SpitterService spitterService = mock(SpitterService.class);
		
		when(spitterService.getRecentSpittles(25))
		.thenReturn(expectedSpittles);
		
		HomeController controller = new HomeController();
		
		Model model =  mock(Model.class);
		String viewName = controller.showHome(model, null);
		
		assertEquals("home", viewName);
		
		assertSame(expectedSpittles,  model.asMap().get("recentSpittles"));
		
	}


}
