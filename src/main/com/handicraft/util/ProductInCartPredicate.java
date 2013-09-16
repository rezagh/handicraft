package com.handicraft.util;

import org.apache.commons.collections.Predicate;

import com.handicraft.vo.CartItemVO;


public class ProductInCartPredicate implements Predicate {
	private String productCode;
	
	public ProductInCartPredicate(String pc){
		this.productCode = pc;
	}
	
	@Override
	public boolean evaluate(Object object) {
    	CartItemVO cartItem = (CartItemVO)object;
    	if(cartItem.getProduct().getCode().equals(productCode)) return true;
        else return false;
	}
}
