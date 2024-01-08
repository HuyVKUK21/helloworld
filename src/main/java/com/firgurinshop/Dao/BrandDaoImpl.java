package com.firgurinshop.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Brand;
import com.firgurinshop.Entity.Product;
import com.firgurinshop.Interface.BrandDao;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional("transactionManager")
	public List<Brand> getBrand() {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Brand> query = builder.createQuery(Brand.class);
			Root<Brand> root = query.from(Brand.class);
			query.select(root);
			Query<Brand> q = session.createQuery(query);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}



}
