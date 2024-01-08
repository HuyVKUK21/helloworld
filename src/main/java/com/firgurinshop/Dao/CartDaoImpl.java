package com.firgurinshop.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Cart;
import com.firgurinshop.Entity.Product;
import com.firgurinshop.Interface.CartDao;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional("transactionManager")
	public List<Cart> getCartByUserId(String user_id) {
		try (Session session = sessionFactory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);
			
			Predicate condition = builder.equal(root.get("user_id"), user_id);
			query.where(condition);
			
			query.select(root);
			Query<Cart> q = session.createQuery(query);
			return q.getResultList();
		} catch (Exception e) {	
			// TODO: handle exception
		}
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
	}

	@Override
	@Transactional("transactionManager")
	public int AddCart(Cart cart) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			try {
				session.save(cart);
				transaction.commit();
				return 1;
			} catch (Exception e) {
				 transaction.rollback();
		          e.printStackTrace();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	@Transactional("transactionManager")
	public int DeleteCart(String cart_id) {
		try (Session session = sessionFactory.openSession()){
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaDelete<Cart> query = builder.createCriteriaDelete(Cart.class);
				Root<Cart> root = query.from(Cart.class);
				
				Predicate condition = builder.equal(root.get("cart_id"), cart_id);
				query.where(condition);
				
				int deletedCount = session.createQuery(query).executeUpdate();
				transaction.commit();
				return deletedCount;
			} catch (Exception e) {
				 if (transaction != null) {
			            transaction.rollback();
			        }
			        e.printStackTrace(); 
			}
			
		} catch (Exception e) {	
			System.out.println("catch: " +e);
		}
		return 0;
	}

}
