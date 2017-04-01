package com.dav.shopping.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dav.shopping.dao.PostCategoryDAO;
import com.dav.shopping.entity.PostCategory;
import com.dav.shopping.service.PostCategoryService;


@Service
public class PostCategoryServiceImpl implements PostCategoryService{

	private PostCategoryDAO postCategoryDAO;

	public void setPostCategoryDAO(PostCategoryDAO postCategoryDAO) {
		this.postCategoryDAO = postCategoryDAO;
	}


	@Override
	public List<PostCategory> getAll() {
		return postCategoryDAO.getAllPost();
	}

}
