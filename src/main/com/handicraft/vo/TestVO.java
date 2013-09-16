package com.handicraft.vo;

public class TestVO extends BaseVO {
	private String orderName;
	private String orderAddressLine1;
	private String orderAddressLine2;//optional
	private String orderCity;
	private String orderState;
	private String orderCountry;
	private String orderPostCode;
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddressLine1() {
		return orderAddressLine1;
	}
	public void setOrderAddressLine1(String orderAddressLine1) {
		this.orderAddressLine1 = orderAddressLine1;
	}
	public String getOrderAddressLine2() {
		return orderAddressLine2;
	}
	public void setOrderAddressLine2(String orderAddressLine2) {
		this.orderAddressLine2 = orderAddressLine2;
	}
	public String getOrderCity() {
		return orderCity;
	}
	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getOrderCountry() {
		return orderCountry;
	}
	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}
	public String getOrderPostCode() {
		return orderPostCode;
	}
	public void setOrderPostCode(String orderPostCode) {
		this.orderPostCode = orderPostCode;
	}


}
