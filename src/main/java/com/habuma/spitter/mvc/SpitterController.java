package com.habuma.spitter.mvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private final SpitterService spitterService;
	
	@Inject
	public SpitterController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	/**
	 * 列出对应spitter的spittles
	 * @param username @RequestParam("spitter")查询参数名为spitter的值，使用@RequestParam防止编译时
	 * 方法参数名丢失而导致无法绑定查询参数到方法
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/spittles", method=GET)
	public String listSpittlesForSpitter(
			@RequestParam("spitter") String username, Model model){
		Spitter spitter = spitterService.getSpitter(username);
		model.addAttribute(spitter);
		model.addAttribute(spitterService.getSpittlesForSpitter(username));
		return "spittles/list";
		
	}
}
