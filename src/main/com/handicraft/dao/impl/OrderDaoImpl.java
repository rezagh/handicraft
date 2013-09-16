package com.handicraft.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.handicraft.dao.OrderDao;
import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;
import com.handicraft.util.Codes;

public class OrderDaoImpl extends GenericDaoImpl implements OrderDao {

	@Override
	public List<OrderDO> getActiveOrders() {
		//no cache needed here.
		return super.getHibernateTemplate().find(Codes.QUERY_ACTIVE_ORDERS);
	}

	@Override
	public List<OrderDO> getUserOrders(UserDO user) {
		DetachedCriteria query = DetachedCriteria.forClass(OrderDO.class).
			add( Property.forName(Codes.COL_ORDER_USER).eq(user)).addOrder(Order.asc(Codes.COL_ORDER_DATE));
		return getHibernateTemplate().findByCriteria(query);
	}
}
