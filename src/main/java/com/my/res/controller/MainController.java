package com.my.res.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.my.res.dao.MembersDao;
import com.my.res.service.MembersService;


@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	private final MembersService membersService;
	
	public MainController (MembersService membersService) {
		this.membersService = membersService;
	}
	
	@GetMapping(value = "/loginSuccess")
	public String loginSuccess(Model model) {
		logger.info("login Sucess.....");
		model.addAttribute("list", membersService.getMembersList());
		
		return "loginSuccess";
		
	}
	
	@GetMapping(value = "/")
	public String loginPage() {
		logger.info("login Page.....");
		return "login";
		
	}
	
	@PostMapping(value = "/loginError")
	public String loginError(){
		logger.info("login Error.....");
		return "loginError";
	}
	
}
