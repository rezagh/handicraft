package com.handicraft.service.impl;

import java.util.Date;
import java.util.List;

import com.handicraft.dao.OrderDao;
import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;
import com.handicraft.model.type.CountryEnum;
import com.handicraft.model.type.OrderStatusEnum;
import com.handicraft.model.type.WeightUnitEnum;
import com.handicraft.service.OrderService;
import com.handicraft.util.Codes;
import com.handicraft.util.OrderUtil;
import com.handicraft.vo.CartItemVO;
import com.handicraft.vo.CartVO;

public class OrderServiceImpl extends GenericServiceImpl  implements OrderService {
	
	OrderDao orderDao;
	
	@Override
	public Double getPostalRate(CountryEnum toCountry, int quantity, Double weight,	WeightUnitEnum weightUnit) {
		return 12d;
	}

	@Override
	public OrderDO submitOrder(CartVO cart, UserDO user) {
		String orderNumber = OrderUtil.generateOrderNumber(user);
		
		//Creating the order
		OrderDO order = new OrderDO();
		order.setUser(user);
		order.setDate(new Date());
		order.setNumber(orderNumber);
		order.setStatus(OrderStatusEnum.ORDER_JUST_SUBMITTED.name());
		order.setTotal(cart.getOrderTotalPrice());
		
		String desc = "";
		for(CartItemVO ci : cart.getCartItems())
			desc = desc + ci.getProduct().getName()+ "-" + ci.getOrderQuantity() +",";
		order.setShortDesc(desc);
		
		try{
			save(order);
			return order;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		//TODO insert the cart to db for later reference
	}

	@Override
	public List<OrderDO> getUserOrders(UserDO user) {
		return orderDao.getUserOrders(user);
	}

	@Override
	public List<OrderDO> getActiveOrders() {
		return orderDao.getActiveOrders();
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public OrderDO getOrderByNumber(String orderNumber) {
		List<OrderDO> out = orderDao.findByColumn(OrderDO.class, Codes.COL_ORDER_NUMBER, orderNumber);
		if(out!= null && out.size() == 1) return out.get(0);
		return null;
	}

	@Override
	public List<OrderDO> getAllOrders() {
		//TODO this needs paging
		return orderDao.getAll(OrderDO.class);
	}

}
