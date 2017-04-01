package com.dav.shopping.dao;

import java.util.List;

import com.dav.shopping.entity.ProductCategory;
import com.dav.shopping.utils.PaginationSet;

public interface ProductCategoryDAO {
	PaginationSet<ProductCategory> getAllByPage(int page, int pageSize);
	PaginationSet<ProductCategory> getAllByKeyword(int page, int pageSize, String keyword);
	
	Boolean create(ProductCategory productCategory);
	Boolean isExist(ProductCategory productCategory);
	
	ProductCategory findById(Integer id);
	List<ProductCategory> getAll();
}
