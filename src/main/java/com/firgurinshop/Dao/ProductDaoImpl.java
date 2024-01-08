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

import com.firgurinshop.Entity.Category;
import com.firgurinshop.Entity.Product;
import com.firgurinshop.Interface.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional("transactionManager")
	public List<Product> getAllProduct() {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.equal(root.get("category_id"), 3);
			query.where(condition);
			query.select(root);
			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataProduct(String id) {
		// TODO Auto-generated method stub
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.equal(root.get("product_id"), id);
			query.where(condition);

			query.select(root);
			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataProductAvailable() {
		// TODO Auto-generated method stub
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.equal(root.get("category_id"), 2);
			query.where(condition);

			query.select(root);
			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataFilter(String id) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);
			if (id.equals("all")) {
				query.select(root);
				Query<Product> q = session.createQuery(query);
				return q.getResultList();
			} else {
				Predicate condition = builder.equal(root.get("category_id"), id);
				query.where(condition);
				query.select(root);
				Query<Product> q = session.createQuery(query);
				return q.getResultList();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getProductSize() {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			query.select(root).distinct(true);
			query.groupBy(root.get("product_size"));
			query.orderBy(builder.asc(root.get("product_size")));
			Query<Product> q = session.createQuery(query);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getFilterBrand(String tradeMark) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.equal(root.get("brand_id"), tradeMark);
			query.where(condition);

			query.select(root);

			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getFilterSize(String productSize) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.equal(root.get("product_size"), productSize);
			query.where(condition);

			query.select(root);

			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getSearchProduct(String keyword) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);

			Predicate condition = builder.like(root.get("product_name"), "%" + keyword + "%");
			query.where(condition);

			query.select(root);

			Query<Product> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

}
