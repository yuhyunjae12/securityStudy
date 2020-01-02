package com.my.res.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.my.res.utill.MessageUtils;

@ControllerAdvice
public class ControllerAdviceRes {
	
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdviceRes.class);
    
    @ExceptionHandler(BadCredentialsException.class)
    public void BadCredentials(HttpServletRequest request, BadCredentialsException e) {
    	logger.info("BadCredentialsException : " + e.getMessage());
    	request.setAttribute("errormsg", MessageUtils.getMessage("error.BadCredentials"));
    }
	
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public void InternalAuthenticationService(HttpServletRequest request, InternalAuthenticationServiceException e) {
    	logger.info("InternalAuthenticationServiceException : " + e.getMessage());
    	request.setAttribute("errormsg", MessageUtils.getMessage("error.BadCredentials"));
    }
    
    @ExceptionHandler(CredentialsExpiredException.class)
    public void CredentialsExpired(HttpServletRequest request, CredentialsExpiredException e) {
    	logger.info("CredentialsExpiredException : " + e.getMessage());
    	request.setAttribute("errormsg", MessageUtils.getMessage("error.CredentialsExpired"));
    }
    
    @ExceptionHandler(DisabledException.class)
    public void Disabled(HttpServletRequest request, DisabledException e) {
    	logger.info("DisabledException : " + e.getMessage());
    	request.setAttribute("errormsg", MessageUtils.getMessage("error.Disaled"));
    }
}
