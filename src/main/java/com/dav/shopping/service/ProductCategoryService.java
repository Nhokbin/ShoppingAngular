package com.dav.shopping.service;

import java.util.List;


import com.dav.shopping.entity.ProductCategory;
import com.dav.shopping.utils.PaginationSet;

public interface ProductCategoryService {
	PaginationSet<ProductCategory>  getAllByPage(int page, int pageSize);
	PaginationSet<ProductCategory>  getAllByKeyword(int page, int pageSize,String keyword);
	
	Boolean create(ProductCategory productCategory);
	Boolean isExist(ProductCategory productCategory);
	List<ProductCategory> getAll();
	
}
