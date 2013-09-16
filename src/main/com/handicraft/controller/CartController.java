package com.handicraft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.util.CartHelper;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;
import com.handicraft.vo.CartItemVO;

public class CartController extends ParentMultiAction  {
	Log log = LogFactory.getLog(CartController.class);
	CartHelper helper;
	
	public ModelAndView showCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ControllerUtil.addCountiesToSession(request);
		helper.initCart(request);
		helper.updateCart(request);
		return new ModelAndView(Codes.PAGE_CART);
	}

	public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		helper.addSessionProductToCart(request);
		helper.addCountryToCart(request);
		return new ModelAndView(Codes.PAGE_CART);
	}

	public ModelAndView removeFromCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		helper.removeFromCart(request);
		return new ModelAndView(Codes.PAGE_CART);
	}

	public ModelAndView clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		helper.clearCart(request);
		return new ModelAndView(Codes.PAGE_CART);
	}

	public ModelAndView updateCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		helper.updateCart(request);
		
		//TODO calculate postage,etc and put it back into cart
		return new ModelAndView(Codes.PAGE_CART);
	}

	public void setHelper(CartHelper helper) {
		this.helper = helper;
	}
	
	public ModelAndView showAddressConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(ControllerUtil.getUser() == null)	//not logged in
			return new ModelAndView("login");
		else{
			ControllerUtil.setUserToSession(request);
			return new ModelAndView(Codes.PAGE_ADDRESS_CONFIRMATION);
		}
	}

	
}
