package com.handicraft.dao.impl;

import java.util.List;

import com.handicraft.dao.ProductDao;
import com.handicraft.model.ProductCategoryDO;
import com.handicraft.model.ProductDO;
import com.handicraft.util.Codes;

public class ProductDaoImpl extends GenericDaoImpl implements ProductDao{

	@Override
	public List<ProductDO> getProductsByCategory(ProductCategoryDO category) {
		return super.findByQuery(Codes.QUERY_PRODUCTS_BY_CATEGORY, category.getId());
	}

}
