package com.dav.shopping.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dav.shopping.dao.PostCategoryDAO;
import com.dav.shopping.entity.PostCategory;


@Transactional
@Repository
public class PostCategoryDAOImpl implements PostCategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(PostCategoryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostCategory> getAllPost() {
		Session session= sessionFactory.getCurrentSession();
		List<PostCategory> postCategories = session.createQuery("from PostCategory").list();
		return postCategories;
	}

}
