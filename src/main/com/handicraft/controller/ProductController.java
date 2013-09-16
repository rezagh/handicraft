package com.handicraft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;
import com.handicraft.service.ProductCategoryService;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;

public class ProductController extends ParentMultiAction {
	ProductCategoryService service;
	
	public ModelAndView getProductsByCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long catId =  new Long(request.getParameter("categoryId"));
		
		ProductCategoryDO category = new ProductCategoryDO(catId);
		List<ProductDO> products = service.getProductsByCategory(category);
		
//		request.getSession().setAttribute("events", events );
//		request.getSession().setAttribute("types", EventTypeEnum.values() );
//		request.getSession().setAttribute("cities", CityEnum.values() );
		
		Map model = new HashMap();
		model.put(Codes.VAR_PRODUCTS, products);
		return new ModelAndView(Codes.PAGE_LIST_PRODUCTS_FOR_CATEGORY,model);
		
		
//		Map model = errors.getModel();
//		model.put("products", products);
//		return new ModelAndView("listProductsForCategory",model);
		
	}

	public ModelAndView getProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = new Long(request.getParameter("productId"));
		
		ProductDO product = service.getProduct(id);
		Map model = new HashMap();
		model.put(Codes.VAR_PRODUCT, product);
		request.getSession().setAttribute(Codes.VAR_PRODUCT, product);
		//TODO country list might be needed else where too
		ControllerUtil.addCountiesToSession(request);
		return new ModelAndView(Codes.PAGE_LIST_PRODUCT);
	}

	public void setService(ProductCategoryService service) {
		this.service = service;
	}
}
