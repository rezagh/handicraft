package com.handicraft.util;


public class Codes {
	
	//Args in JSP
	public static final String PRODUCT_CODE = "productCode";
	public static final String CATEGORY_CODE = "categoryCode";
	public static final String COUNTRIES = "countries";
	public static final String WEIGHTS = "weights";
	
	//Variables in JSP
	public static final String VAR_PRODUCTS = "products";
	public static final String VAR_PRODUCT = "product";
	public static final String VAR_INQUIRY_TYPES = "inquiryTypes";
	public static final String VAR_CATEGORIES = "categories";
	public static final String VAR_ORDER = "order";
	public static final String VAR_CART = "cart";
	public static final String VAR_ORDERS = "orders";
	public static final String VAR_IMAGE_ID = "imageId";
	
	//order vars
	public static final String VAR_ORDER_NAME = "orderName";
	public static final String VAR_ORDER_ADDRS1 = "orderAddressLine1";
	public static final String VAR_ORDER_ADDRS2 = "orderAddressLine2";
	public static final String VAR_ORDER_STATE = "orderState";
	public static final String VAR_ORDER_POSTCODE = "orderPostCode";
	public static final String VAR_ORDER_COUNTRY = "orderCountry";
	public static final String VAR_ORDER_CITY = "orderCity";
	public static final String VAR_ORDER_QUANTITY = "orderQuanity";
	
	public static final String VAR_PARTIAL_NEW_QUANTITY = "_new_quantity";
	
	//Page Names
	public static final String PAGE_LIST_PRODUCTS_FOR_CATEGORY = "listProductsForCategory";
	public static final String PAGE_LIST_INQUIRY = "inquiry";
	public static final String PAGE_LIST_PRODUCT = "listProduct";
	public static final String PAGE_ORDER_CREATION = "orderCreation";
	public static final String PAGE_ORDER_CONFIRMATION = "orderConfirmation";
	public static final String PAGE_ORDER_HISTORY = "orderHistory";
	public static final String PAGE_ADDRESS_CONFIRMATION = "addressConfirmation";
	public static final String PAGE_CART = "cart";
	public static final String PAGE_INDEX = "index";
	public static final String PAGE_MANAGER_MENU = "manager";
	public static final String PAGE_ACTIVE_ORDERS = "orders";
	
	//Hibernate col names
	public static final String COL_ORDER_PAYMENT_STATUS = "paymentStatus";
	public static final String COL_ORDER_USER = "user";
	public static final String COL_ORDER_STATUS = "status";
	public static final String COL_ORDER_DATE = "date";
	public static final String COL_ORDER_NUMBER = "number";
	
	//Query
	public static final String QUERY_ACTIVE_ORDERS = "select order from OrderDO order where order.status = 'ORDER_JUST_SUBMITTED' or  order.status = 'ORDER_PROCESSING'";
	public static final String QUERY_PRODUCTS_BY_CATEGORY = "select product from ProductDO product where product.category.id = ?";
	public static final String QUERY_PRODUCT_BY_ID = "select product from ProductDO product where product.id = ?";
	
}
