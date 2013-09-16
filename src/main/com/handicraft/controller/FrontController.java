package com.handicraft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.handicraft.model.ProductCategoryDO;
import com.handicraft.service.ProductCategoryService;
import com.handicraft.util.Codes;

public class FrontController implements Controller 
{
	ProductCategoryService service;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute(Codes.VAR_CATEGORIES ,service.getAll(ProductCategoryDO.class));
		return new ModelAndView("index");
    }
	public void setService(ProductCategoryService service) {
		this.service = service;
	}
}
