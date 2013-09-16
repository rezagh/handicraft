package com.handicraft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.handicraft.model.ProductCategoryDO;
import com.handicraft.service.ProductCategoryService;

public class CategoryController extends ParentMultiAction {
	ProductCategoryService service;
	

	public ModelAndView getCategories(HttpServletRequest request, HttpServletResponse response) throws Exception {
		service.getAll(ProductCategoryDO.class);
		return null;
	}

	public ModelAndView getCategoryByCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("");
		service.getCategoryByCode(code);
		return null;
	}
	
	public void setService(ProductCategoryService service) {
		this.service = service;
	}

}
