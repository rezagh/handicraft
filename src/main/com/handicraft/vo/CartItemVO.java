package com.handicraft.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.handicraft.model.ProductDO;

public class CartItemVO extends BaseVO{
	ProductDO product;
	int orderQuantity;
	//Double postage;	

	public String toString() {
		return new ToStringBuilder(this).
			append("product", product).	
			append("orderQuantity", orderQuantity).
	    	toString();
	}

	public ProductDO getProduct() {
		return product;
	}

	public void setProduct(ProductDO product) {
		this.product = product;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int quantity) {
		this.orderQuantity = quantity;
	}

}
