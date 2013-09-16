package com.handicraft.service;

import java.util.List;

import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;

public interface ProductCategoryService extends GenericService {
	ProductDO getProductByCode(String code);
	ProductDO getProduct(Long id);
	List<ProductDO> getProductsByCategoryCode(String category);
	List<ProductDO> getProductsByCategory(ProductCategoryDO category);
	ProductCategoryDO getCategoryByCode(String code);
	
	//List<ProductCategoryDO> getCategories();
}

