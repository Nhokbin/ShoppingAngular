package com.dav.shopping.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dav.shopping.dao.ProductCategoryDAO;
import com.dav.shopping.entity.ProductCategory;
import com.dav.shopping.utils.PaginationSet;

@Transactional
@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}
	
	@SuppressWarnings("unchecked")
	private PaginationSet<ProductCategory> cover(int[] arrayPage,Query query){
		
		PaginationSet<ProductCategory> paginationSet = new PaginationSet<ProductCategory>();
		paginationSet.setPage(arrayPage[0]);
		paginationSet.setTotalCount(query.list().size());
		
		paginationSet.setTotalPages((int) Math.ceil(query.list().size()/(arrayPage[1]*1.0)));
		
		paginationSet.setItems(query.
				setFirstResult(arrayPage[0] * arrayPage[1])
				.setMaxResults(arrayPage[1])
				.list());
		paginationSet.setCount(query
				.setFirstResult(arrayPage[0] * arrayPage[1])
				.setMaxResults(arrayPage[1])
				.list()
				.size());
		
		return paginationSet;
		
	}
	
	@Override
	public List<ProductCategory> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From ProductCategory";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	@Override
	public PaginationSet<ProductCategory> getAllByPage(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From ProductCategory";
		Query query = session.createQuery(hql);
		
	
		return cover(new int[]{page, pageSize}, query);
	}



	
	@Override
	public PaginationSet<ProductCategory> getAllByKeyword(int page, int pageSize,String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From ProductCategory pc Where pc.name Like :keyword Or pc.description Like :keyword Or pc.alias Like :keyword";
		
		Query query = session.createQuery(hql);
		query.setString("keyword", "%"+keyword+"%");
		
		return cover(new int[]{page, pageSize}, query);
	}

	@Override
	public Boolean create(ProductCategory productCategory) {
		Boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(productCategory);
			transaction.commit();
			result = true;
		}catch(Exception ex){
			ex.printStackTrace();
			transaction.rollback();
			result = false;
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean isExist(ProductCategory productCategory) {
	
		return findById(productCategory.getId())!=null;
	}

	@Override
	public ProductCategory findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (ProductCategory) session.load(ProductCategory.class, id);
	}

	



}
