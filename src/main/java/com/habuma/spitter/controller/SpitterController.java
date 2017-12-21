package com.habuma.spitter.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;
import com.habuma.spitter.util.ImageUploadException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitters")
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
	
	
	/**
	 * valid用于校验spitter是否符合实体类内的设置
	 * @param spitter
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
			@RequestParam(value="image",required=false) MultipartFile image,HttpSession session){
		
		if(bindingResult.hasErrors()){
			return "spitters/edit";
		}
		
//		Spitter loggedSpitter = (Spitter) session.getAttribute("loggedSpitter");
		String realPath = session.getServletContext().getRealPath("/resources");
		
		try {
			if(!image.isEmpty()){
				validateImage(image);//验证图片
				
				saveImage(spitter.getId() + ".jpg",image,realPath);//保存图片文件
			}
		} catch (Exception e) {
			bindingResult.reject(e.getMessage());
			return "spitters/edit";
		}
		
		spitterService.savaSpitter(spitter);
		
		return "redirect:/spitters/" + spitter.getUsername();
	}
	
	/**
	 * 保存图片
	 * @param filename
	 * @param image
	 * @param realPath
	 * @throws ImageUploadException
	 */
	private void saveImage(String filename, MultipartFile image, String realPath) throws ImageUploadException {

		try {
			File file = new File(realPath + "/avatars/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch(IOException e) {
			throw new ImageUploadException("Unable to upload image", e);
		}
	}

	/**
	 * 验证图片格式
	 * @param image
	 * @throws ImageUploadException
	 */
	private void validateImage(MultipartFile image) throws ImageUploadException {
		if(!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted.");
		}
	}
	/**
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		model.addAttribute(spitterService.getSpitter(username));
		return "spitters/view";
	}
}
