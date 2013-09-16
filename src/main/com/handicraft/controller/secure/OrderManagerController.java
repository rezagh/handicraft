package com.handicraft.controller.secure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.handicraft.controller.ParentMultiAction;
import com.handicraft.model.OrderDO;
import com.handicraft.model.type.OrderStatusEnum;
import com.handicraft.model.type.PaymentStatusEnum;
import com.handicraft.service.OrderService;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;

public class OrderManagerController extends ParentMultiAction {
	OrderService orderService;

	public ModelAndView showActiveOrders(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		List orders = orderService.getActiveOrders();
		map.put("orders",orders );
		
		return new ModelAndView(Codes.PAGE_ACTIVE_ORDERS,map);
	}

	public ModelAndView showAllOrders(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		List orders = orderService.getAllOrders();
		map.put("orders",orders );
		
		return new ModelAndView(Codes.PAGE_ACTIVE_ORDERS,map);
	}

	public ModelAndView showChangeOrderPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		
		String orderNumber = request.getParameter("orderNumber");
		OrderDO order = orderService.getOrderByNumber(orderNumber);
		map.put("order", order);

		map.put("orderStatusValues",OrderStatusEnum.values());
		map.put("paymentStatusValues",PaymentStatusEnum.values());
		
		return new ModelAndView("changeOrder",map);
	}
	
	public ModelAndView changeOrder(HttpServletRequest request, HttpServletResponse response,OrderDO order) throws Exception {
		OrderDO dbOrder = orderService.getOrderByNumber(order.getNumber());
		
		dbOrder.setOperator(ControllerUtil.getUser());
		dbOrder.setPaymentStatus(order.getPaymentStatus());
		dbOrder.setStatus(order.getStatus());
		
		orderService.update(dbOrder);
		return showActiveOrders(request,response);
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
