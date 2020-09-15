package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic...............");
	}    
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		
		log.info("basic get..................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("n") String name, @RequestParam("a") int age) {
		
		log.info("name:"+name);
		log.info("age: "+age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@RequestMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ids: "+Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list ) {
		log.info("list dtos: "+list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex04")   //기본 자료형은 화면에 전달되지 않음. ModelAttribute 사용
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: "+dto);
		log.info("page: "+page);  
		
		return "/sample/ex04";
		
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06...................");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("john");
		
		return dto;
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload............");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("-----------------------");
			log.info("name: "+file.getOriginalFilename());
			log.info("size: "+file.getSize());
		});
	}
}
























