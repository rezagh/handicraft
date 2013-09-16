package com.handicraft.service.impl;

import java.util.List;

import com.handicraft.dao.ProductDao;
import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;
import com.handicraft.service.ProductCategoryService;
import com.handicraft.util.Codes;

public class ProductCategoryServiceImpl extends GenericServiceImpl implements ProductCategoryService {
	ProductDao productDao;
	
	private String CODE = "code";
	private String CATEGORY = "category";
	
	@Override
	public ProductCategoryDO getCategoryByCode(String code) {
		List<ProductCategoryDO> out = genericDao.findByColumn(ProductCategoryDO.class, CODE, code);
		return out.get(0);
	}

	@Override
	public ProductDO getProductByCode(String code) {
		List<ProductDO> out = genericDao.findByColumn(ProductDO.class, CODE, code);
		if (out != null && out.size() > 0 )
			return out.get(0);
		return null;
	}

	@Override
	public List<ProductDO> getProductsByCategoryCode(String category) {
		return genericDao.findByColumn(ProductDO.class, CATEGORY , category);
	}

	@Override
	public List<ProductDO> getProductsByCategory(ProductCategoryDO category) {
		return productDao.getProductsByCategory(category);
	}

	@Override
	public ProductDO getProduct(Long id) {
		List out = genericDao.findByQuery(Codes.QUERY_PRODUCT_BY_ID , id);
		return (ProductDO)out.get(0);
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
