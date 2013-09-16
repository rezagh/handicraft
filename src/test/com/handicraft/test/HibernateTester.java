package com.handicraft.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.handicraft.dao.GenericDao;
import com.handicraft.dao.OrderDao;
import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;

public class HibernateTester extends BaseTest{
	
	GenericDao genericDao;
	OrderDao orderDao;
	@Before
	public void setup(){
		//dao = (GenericDao)applicationContext.getBean("genericDao");
		genericDao = (GenericDao)factory.getBean("genericDao");
		orderDao = (OrderDao)factory.getBean("orderDao");
		
	}
	
	@Test
	public void testSaveOrderDO(){
		OrderDO order = new OrderDO();
		
		order.setDate(new Date());
		order.setNumber("sfsfs");
		order.setPaymentStatus("ss");
		order.setStatus("zz");
		UserDO user = new UserDO();
		user.setId(123l);
		order.setUser(user);
		
		genericDao.save(order);
	}
	
	@Test
	public void testActiveOrders(){
		List out = orderDao.getActiveOrders();
		System.out.println(out.size());
	}
	
	@Test
	public void testGetUserOrders(){
		UserDO user = new UserDO();
		user.setId(1l);
		List out = orderDao.getUserOrders(user);
		System.out.println(out);
	}
	
	@Test
	public void testUpdateAccount(){
		UserDO user = new UserDO();
		user.setId(1l);
		List out = orderDao.getUserOrders(user);
		System.out.println(out);
	}

}

