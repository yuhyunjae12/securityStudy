package com.my.res.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();
        
        logger.info("login user id ....." + id);

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
	
	@GetMapping( value = "/signUpForm")
	public String signUpForm() {
		return "signUp";
	}
	
	@PostMapping( value = "/signUp")
	public String signUp(@RequestParam HashMap<String, Object> map) {
		int res = membersService.insertMembers(map);
		return "redirect:/";
	}
	
}
