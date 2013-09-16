package com.handicraft.controller.secure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.controller.ParentMultiAction;
import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;
import com.handicraft.model.type.WeightUnitEnum;
import com.handicraft.service.GenericService;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;

public class ProductManagerController extends ParentMultiAction {
	GenericService genericService;
	
	public ModelAndView showProductManager(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView(Codes.PAGE_MANAGER_MENU);
	}
	
	public ModelAndView showAddProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute(Codes.WEIGHTS, Arrays.asList( WeightUnitEnum.values()));
		//TODO cache
		request.getSession().setAttribute(Codes.VAR_CATEGORIES, genericService.getAll(ProductCategoryDO.class));
		return new ModelAndView("addProduct");
	}

	public ModelAndView showAddCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute(Codes.VAR_CATEGORIES, genericService.getAll(ProductCategoryDO.class));
		return new ModelAndView("addCategory");
	}

	public ModelAndView addCategory(HttpServletRequest request, HttpServletResponse response, ProductCategoryDO category) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		try{
			category.getCode().toLowerCase();
			category.setImageRef(category.getCode()+ ".jpg");
			if(category.getParentCategory() == null || category.getParentCategory().getId() == null)
				category.setParentCategory(null);
			
			
			genericService.save(category);	
			map.put("result", "Added");
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "Failed");
		}
		return new ModelAndView("addCategory",map);
	}

	public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response, ProductDO product) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		try{
			product.setImageRef(product.getCode()+ ".jpg");
			genericService.save(product);	
			map.put("result", "Added");
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "Failed");
		}
		return new ModelAndView("addProduct",map);
	}

	public ModelAndView removeProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("productId");
		ProductDO p = new ProductDO(new Long(id));
		genericService.delete(p);
		return viewProducts(request,response);
	}
	
	public ModelAndView removeCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("catId");
		ProductCategoryDO c = new ProductCategoryDO(new Long(id));
		genericService.delete(c);
		return viewCategories(request,response);
	}


	public ModelAndView viewCategories(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductCategoryDO> cats = genericService.getAll(ProductCategoryDO.class);
		Map<String,List<ProductCategoryDO>> map = new HashMap<String, List<ProductCategoryDO>>();
		map.put(Codes.VAR_CATEGORIES, cats);
		return new ModelAndView("viewCategories",map);
	}

	public ModelAndView viewProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDO> products = genericService.getAll(ProductDO.class);
		Map<String,List<ProductDO>> map = new HashMap<String, List<ProductDO>>();
		map.put(Codes.VAR_PRODUCTS, products);
		return new ModelAndView("viewProducts",map);
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}
}
