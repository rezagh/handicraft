package com.handicraft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * This takes care of exceptions and directs them to the correct page
 * @author Reza
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver  {
	Log log = LogFactory.getLog(CustomExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
		//this is not always a good idea to come here. better to handle exception in the controller method itself.
		
		ex.printStackTrace();

		if(ex instanceof AccessDeniedException)	return new ModelAndView("login");
		else return new ModelAndView("index");
	}
}
