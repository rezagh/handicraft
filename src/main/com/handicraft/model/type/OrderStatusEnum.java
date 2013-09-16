package com.handicraft.model.type;

public enum OrderStatusEnum {
	ORDER_JUST_SUBMITTED("Just Submitted"),
	ORDER_CANCELED("Cancelled"),
	ORDER_POSTED("Posted"),
	ORDER_PROCESSING("Processing"),
	BUYER_RECEIVED("Received");
	
	String engName;
	
	private OrderStatusEnum(String name){
		this.engName = name;
	}

	public String getEngName(){
		return this.engName;
	}
}
