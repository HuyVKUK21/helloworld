package com.firgurinshop.Dao;

import javax.persistence.criteria.CriteriaBuilder;
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

import com.firgurinshop.Entity.Product;
import com.firgurinshop.Entity.User;
import com.firgurinshop.Interface.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional("transactionManager")
	public User checkAccount(User user) {
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);

			Predicate condition = builder.equal(root.get("user_email"), user.getUser_email());
			query.where(condition);

			query.select(root);
			Query<User> q = session.createQuery(query);
			return (User) q.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return (User) sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	@Transactional("transactionManager")
	public int AddAccount(User user) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			try {
				session.save(user);
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

}
