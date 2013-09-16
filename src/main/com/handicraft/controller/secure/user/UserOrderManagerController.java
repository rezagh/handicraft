package com.handicraft.controller.secure.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.controller.ParentMultiAction;
import com.handicraft.model.OrderDO;
import com.handicraft.model.UserDO;
import com.handicraft.service.OrderService;
import com.handicraft.util.CartHelper;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;
import com.handicraft.vo.CartItemVO;
import com.handicraft.vo.CartVO;

public class UserOrderManagerController extends ParentMultiAction {
	Log log = LogFactory.getLog(UserOrderManagerController.class);
	
	OrderService orderService;
	CartHelper cartHelper;

	public ModelAndView showOrderConfirmation(HttpServletRequest request, HttpServletResponse response, CartItemVO cartItem) throws Exception {
		//cartHelper.addAddressToCart(request);
		//TODO calculate price again here as user might have change the country
		return new ModelAndView(Codes.PAGE_ORDER_CONFIRMATION);
	}

	public ModelAndView showOrderHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		List orders = orderService.getUserOrders(ControllerUtil.getUser());
		map.put(Codes.VAR_ORDERS,orders );
		return new ModelAndView(Codes.PAGE_ORDER_HISTORY,map);
	}

	public ModelAndView submitPaypalOrder(HttpServletRequest request, HttpServletResponse response,CartVO cartVO) {
		CartVO cart = cartHelper.getCart(request);
		UserDO user = ControllerUtil.getUser();
		OrderDO order = orderService.submitOrder(cart, user );
		log.debug("order number is = " + order );
		try {
			cartHelper.clearCart(request);//we don't want to see the same cart after submitting the order
			gotoPaypal(request,response,cart, order);
		} catch (IOException e) {
			e.printStackTrace();
			//TODO goto some other page !
		}
		return null;
	}

	public ModelAndView submitAndPayLater(HttpServletRequest request, HttpServletResponse response)throws Exception {
		CartVO cart = cartHelper.getCart(request);
		UserDO user = ControllerUtil.getUser();
		OrderDO order = orderService.submitOrder(cart, user );
		log.debug("order number is = " + order );
		cartHelper.clearCart(request);//we don't want to see the same cart after submitting the order
		//TODO Send email to the user here and inform about bank transfer details - how to pay in Paypal, etc.
		response.sendRedirect("order.htm?method=showOrderHistory");//this is to stop duplicate form submissions. calling showOrderHistory method will result in duplicate form submissions.
		return null;
	}

	private void  gotoPaypal(HttpServletRequest request, HttpServletResponse response, CartVO cart,OrderDO order ) throws IOException{
		//https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_xclick&business=BGGZEMRSFU9AW&button_subtype=products&item_number=2345&cn=Add special instructions to the seller&no_shipping=1&rm=2&return=http://google.com&cancel_return=http://bbcpersian.com&currency_code=USD&amount=44&item_name=alifd
		//https://www.paypal.com/cgi-bin/websc?cmd=_xclick&business=J5EU4W77A8MVE&
		
		Double total = cart.getOrderTotalPrice();
		
		response.sendRedirect("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_xclick&business=BGGZEMRSFU9AW&" +
			"button_subtype=products&" +
			"cn=Add_special_instructions_to_the_seller&" +
			"item_number= "+ order.getNumber() +"&" +
			"no_shipping=1&" + //no prompt for address
			"amount=" + total + "&" +
			"rm=2&"+ //return method
			"return=http://127.0.0.1:8080/handicraft/order.htm?method=paid&" +
			"cancel_return=http://127.0.0.1:8080/handicraft/order.htm?method=notPaid&" +
			"currency_code=USD&" +
			"item_name=" + order.getShortDesc());
	}

	//after returning from paypal - paid
	public ModelAndView paid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orderNumber = request.getParameter("item_number");
		OrderDO order = orderService.getOrderByNumber(orderNumber);
		
		if(order != null) {
			order.setPaymentStatus(com.handicraft.model.type.PaymentStatusEnum.RECEIVED.name());
			orderService.update(order);
		}else{
			notPaid(request,response);
		}
		
		return new ModelAndView("paidOk");
	}

	//after returning from paypal - cancelled
	public ModelAndView notPaid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("notPaid");
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setCartHelper(CartHelper cartHelper) {
		this.cartHelper = cartHelper;
	}

}
