package com.handicraft.service;

import java.util.List;

import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;
import com.handicraft.model.type.CountryEnum;
import com.handicraft.model.type.WeightUnitEnum;
import com.handicraft.vo.CartVO;

public interface OrderService extends GenericService {
	public Double getPostalRate(CountryEnum toCountry, int quantity, Double weight, WeightUnitEnum weightUnit);
	/**
	 * 
	 * @param cart
	 * @param user
	 * @return OrderDO
	 */
	public OrderDO submitOrder(CartVO cart,UserDO user);
	
	/**
	 * Returns active orders for all users to manager
	 * @return list of active orders
	 */
	public List<OrderDO> getActiveOrders();

	/**
	 * Returns all orders for all users to manager. needs paging
	 * @return list of orders
	 */
	public List<OrderDO> getAllOrders();

	/**
	 * Returns all orders related to a user
	 * @param user
	 * @return list of user orders
	 */
	public List<OrderDO> getUserOrders(UserDO user);
	
	
	public OrderDO getOrderByNumber(String orderNumber);
}
