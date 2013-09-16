package com.handicraft.model.type;

public enum PaymentStatusEnum {
	RECEIVED("Received"),
	NOT_RECEIVED("Not Received"),
	PARTIALLY_RECEIVED("Partially Received"),//payment not fully received
	REFUNDED("Refunded");
	
	
	private String engName;
	
	private PaymentStatusEnum(String name){
		this.engName = name;
	}
	
	public String getEngName(){
		return this.engName;
	}
}
