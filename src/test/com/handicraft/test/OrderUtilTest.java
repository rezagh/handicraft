package com.handicraft.test;

import org.junit.Test;

import com.handicraft.util.OrderUtil;

public class OrderUtilTest {
	@Test
	public void testGenerateOrderNumber(){
		
		String out = OrderUtil.generateOrderNumber(null);
		System.out.println(out);
	}

}
