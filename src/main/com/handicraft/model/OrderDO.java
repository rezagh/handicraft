package com.handicraft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;

import com.handicraft.model.type.OrderStatusEnum;
import com.handicraft.model.type.PaymentStatusEnum;
import com.reza.datetime.DateUtil;

@Entity
@Table(name = "ORDERS")
public class OrderDO extends BaseDO{
	@Column(name="NUMBER")
	private String number;

	@Column(name="ORDER_DATE")
	private Date date;
	
	@Column(name="STATUS")
	private String status;
	//private transient OrderStatusEnum statusEnum;
	
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;
	//private transient PaymentStatusEnum paymentStatusEnum;
	
	@Column(name="SHORT_DESC")
	private String shortDesc;

	@Column(name="TOTAL")
	private Double total;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name="USER_ID")
	private UserDO user;

	@ManyToOne(fetch=FetchType.EAGER,optional=true)
    @JoinColumn(name="OPERATOR_ID")
	private UserDO operator;

	public String getSimpleDate(){
		if(this.getDate() != null)
			return DateUtil.simpleDate(getDate().getTime());
		return "";
	}
	//TODO we need every details of the cart
	//also who is operating on this order from our team
	
	
//	@PostLoad
//	private void fill(){
//		setStatusEnum(OrderStatusEnum.valueOf(this.getStatus()));
//		setPaymentStatusEnum(PaymentStatusEnum.valueOf(this.getPaymentStatus()));
//	}
	
	public OrderStatusEnum getStatusEnum() {
		if(this.getStatus() != null)
			return OrderStatusEnum.valueOf(this.getStatus());
		return null;
	}

	public PaymentStatusEnum getPaymentStatusEnum() {
		if(this.getPaymentStatus() != null)
			return PaymentStatusEnum.valueOf(this.getPaymentStatus());
		return null;
	}
	
//------------------------------------------------------------------
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public OrderStatusEnum getStatusEnum() {
//		return statusEnum;
//	}
//
//	public void setStatusEnum(OrderStatusEnum statusEnum) {
//		this.statusEnum = statusEnum;
//	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

//	public PaymentStatusEnum getPaymentStatusEnum() {
//		return paymentStatusEnum;
//	}
//
//	public void setPaymentStatusEnum(PaymentStatusEnum paymentStatusEnum) {
//		this.paymentStatusEnum = paymentStatusEnum;
//	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public UserDO getOperator() {
		return operator;
	}

	public void setOperator(UserDO operator) {
		this.operator = operator;
	}
}
