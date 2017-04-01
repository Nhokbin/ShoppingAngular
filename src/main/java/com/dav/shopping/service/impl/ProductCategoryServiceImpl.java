package com.dav.shopping.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dav.shopping.dao.ProductCategoryDAO;
import com.dav.shopping.entity.ProductCategory;
import com.dav.shopping.service.ProductCategoryService;
import com.dav.shopping.utils.PaginationSet;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	private ProductCategoryDAO productCategoryDAO;
	
	public void setProductCategoryDAO(ProductCategoryDAO productCategoryDAO) {
		this.productCategoryDAO = productCategoryDAO;
	}
	
	@Override
	public PaginationSet<ProductCategory> getAllByPage(int page, int pageSize) {
		
		return productCategoryDAO.getAllByPage(page,pageSize);
	}

	@Override
	public PaginationSet<ProductCategory> getAllByKeyword(int page, int pageSize, String keyword) {
		// TODO Auto-generated method stub
		return productCategoryDAO.getAllByKeyword(page,pageSize,keyword);
	}

	@Override
	public Boolean create(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return productCategoryDAO.create(productCategory);
	}

	@Override
	public Boolean isExist(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return productCategoryDAO.isExist(productCategory);
	}

	@Override
	public List<ProductCategory> getAll() {
		// TODO Auto-generated method stub
		return productCategoryDAO.getAll();
	}


}
