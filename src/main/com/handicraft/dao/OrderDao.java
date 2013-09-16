package com.handicraft.dao;

import java.util.List;

import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;

public interface OrderDao extends GenericDao{
	public List<OrderDO> getActiveOrders();
	public List<OrderDO> getUserOrders(UserDO user);
}
