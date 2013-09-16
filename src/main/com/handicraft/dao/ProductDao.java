package com.handicraft.dao;

import java.util.List;

import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;

public interface ProductDao {
	List<ProductDO> getProductsByCategory(ProductCategoryDO  category);
}
