package com.handicraft.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CartVO extends BaseVO{
	
	private Set<CartItemVO> cartItems = new HashSet<CartItemVO>();
	private String orderCountry;
	private Double orderPostage;
	private Double orderTotalPrice;

//----------------------------------------------------------------------------------	
	public String toString() {
		return new ToStringBuilder(this).
			append("cartItems", cartItems).	
			append("orderCountry", orderCountry).
	    	toString();
	}

	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Set<CartItemVO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItemVO> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getOrderPostage() {
		return orderPostage;
	}

	public void setOrderPostage(Double orderPotage) {
		this.orderPostage = orderPotage;
	}
	public String getOrderCountry() {
		return orderCountry;
	}

	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}
}
