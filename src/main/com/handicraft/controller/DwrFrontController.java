package com.handicraft.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.handicraft.service.OrderService;

public class DwrFrontController {
	private static final Log log = LogFactory.getLog(DwrFrontController.class);

	OrderService orderService;


    public Double getPostalRate(String toCountry, int quantity, Double weight, String weightUnit){
    	//TODO validate
    	System.out.println("country= " +toCountry + " quantity= " +quantity + " weight= " + weight + " weightunit= " +  weightUnit);
    	return 1d;
    	//return orderService.getPostalRate(CountryEnum.valueOf(toCountry), quantity, weight, weightUnit);
    }
    
}
