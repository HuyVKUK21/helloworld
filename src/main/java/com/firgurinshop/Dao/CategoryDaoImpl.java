package com.firgurinshop.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Category;
import com.firgurinshop.Entity.Product;
import com.firgurinshop.Interface.CategoryDao;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional("transactionManager")
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		try (Session session = sessionFactory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// khởi tạo root
			CriteriaQuery<Category> query = builder.createQuery(Category.class);
			Root<Category> root = query.from(Category.class);
			query.select(root);
			Query<Category> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}


	
	
	
}
