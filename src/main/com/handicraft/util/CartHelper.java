package com.handicraft.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.handicraft.model.ProductDO;
import com.handicraft.model.UserDO;
import com.handicraft.model.type.CountryEnum;
import com.handicraft.model.type.WeightUnitEnum;
import com.handicraft.service.OrderService;
import com.handicraft.vo.CartItemVO;
import com.handicraft.vo.CartVO;

public class CartHelper {
	private static Log log = LogFactory.getLog(CartHelper.class);
	private OrderService orderService;
	
	public void addSessionProductToCart(HttpServletRequest request){
		ProductDO product = (ProductDO)request.getSession().getAttribute(Codes.VAR_PRODUCT);
		if(product == null) return;
		
		CartVO cart = getCart(request);
		
		if(isProductInCart(cart, product)){
			
			//TODO do something later maybe overwrite
			log.debug("product exists in the cart=" + product);
			//TODO set quantity too
		}else{
			CartItemVO cartItem = new CartItemVO();
			cartItem.setProduct(product);
			cartItem.setOrderQuantity(1);
			cart.getCartItems().add(cartItem);
			
			//TODO should this be here?
			String orderQuantity = request.getParameter(Codes.VAR_ORDER_QUANTITY);
			if(StringUtils.isNumeric(orderQuantity)) cartItem.setOrderQuantity(new Integer(orderQuantity));
		}
		updateCart(request);
	}
	
	public void getProductInCart(HttpServletRequest request){
	}
	
	
	public void initCart(HttpServletRequest request){
		getCart(request);
	}
	
	public void clearCart(HttpServletRequest request){
		request.getSession().setAttribute(Codes.VAR_CART, new CartVO());
	}

	public void updateCart(HttpServletRequest request){
		updateCartQuantities(request);
		addCountryToCart(request);
		
		CartVO cart = getCart(request);
		UserDO user = ControllerUtil.getUser();
		if(user != null) cart.setOrderCountry(user.getCountry());//for calculating postage
		calculatePostageAndTotalPrice(cart);
	}

	/*
	 * updates the cart with the new quantities entered by user and submitted
	 */
	private void updateCartQuantities(HttpServletRequest request){
		CartVO cart = getCart(request);

		for(CartItemVO ci :cart.getCartItems()){
			String param = ci.getProduct().getCode()+ Codes.VAR_PARTIAL_NEW_QUANTITY;
			log.debug(param);
			String newQuantity = request.getParameter(param);
			
			if(!StringUtils.isEmpty(newQuantity) && StringUtils.isNumeric(newQuantity)){
				Integer iNewQuantity = new Integer(newQuantity);
				//observing max quantity
				if(iNewQuantity.intValue() >= ci.getProduct().getQuantity())
					ci.setOrderQuantity(ci.getProduct().getQuantity());
				else ci.setOrderQuantity(iNewQuantity);
			}
		}
	}

	/*
	 * total price of the cart + postage
	 */
	private void calculatePostageAndTotalPrice(CartVO cart){
		Double postagePrice = calculatePostagePrice(cart);
		cart.setOrderPostage(postagePrice);
		
		Double total = 0d;
		for(CartItemVO cartItem : cart.getCartItems()){
			total = total + (cartItem.getProduct().getPrice() * cartItem.getOrderQuantity());
		}
		
		if (total == 0) // cart empty 
			cart.setOrderTotalPrice(total);
		else {
			total = total + postagePrice;
			cart.setOrderTotalPrice(total);
		}
	}
	
	private Double calculatePostagePrice(CartVO cart){
		
		Double totalPostage = 0d;
		if(!StringUtils.isEmpty(cart.getOrderCountry()))//user logged in
			for(CartItemVO cartItem : cart.getCartItems()){
				totalPostage = totalPostage + orderService.getPostalRate(CountryEnum.valueOf(cart.getOrderCountry()), cartItem.getOrderQuantity(), 
						cartItem.getProduct().getWeight(), WeightUnitEnum.valueOf(cartItem.getProduct().getWeightUnit()));
			}
		return totalPostage;
	}
	
	public void addCountryToCart(HttpServletRequest request){
		CartVO cart = getCart(request);
		String orderCountry = request.getParameter(Codes.VAR_ORDER_COUNTRY);
		if(! StringUtils.isEmpty(orderCountry)) cart.setOrderCountry(orderCountry);
	}
	
	public CartVO getCart(HttpServletRequest request){
		CartVO cart = (CartVO)request.getSession().getAttribute(Codes.VAR_CART);
		if(cart != null) return cart;
		else{
			cart = new CartVO();
			request.getSession().setAttribute(Codes.VAR_CART, cart);
			return cart;
		}
	}

	public boolean isProductInCart(CartVO cart,final ProductDO product){
		return CollectionUtils.exists(cart.getCartItems(), new ProductInCartPredicate(product.getCode()));
	}

	public void removeFromCart(HttpServletRequest request) {
		final String productCode = request.getParameter(Codes.PRODUCT_CODE);
		CartVO cart = getCart(request);
		if(!StringUtils.isEmpty(productCode)) 
			CollectionUtils.filter(cart.getCartItems(), PredicateUtils.notPredicate(new ProductInCartPredicate(productCode)));
		
		updateCart(request);
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}