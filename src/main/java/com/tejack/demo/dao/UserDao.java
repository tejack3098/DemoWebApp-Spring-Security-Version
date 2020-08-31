package com.tejack.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tejack.demo.model.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		try {

			Session session = factory.getCurrentSession();

			if (session == null) {
				session = factory.openSession();
			}
			return session;

		} catch (Exception e) {

			System.out.println(e);
		}
		return null;

	}

	public void saveUser(User user) {

		getSession().save(user);
	}


	public String getUserUname(User user) {
		
		
		CriteriaBuilder cb = getSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		
		cr.select(root).where(cb.like(root.get("email"), user.getEmail()));

		Query<User> query = getSession().createQuery(cr);
		List<User> results = query.getResultList();
		
		return results.get(0).getUname();
	}

	public Boolean check_emailId(User user) {
		
		CriteriaBuilder cb = getSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);

		cr.select(root).where(cb.like(root.get("email"), user.getEmail()));

		Query<User> query = getSession().createQuery(cr);
		List<User> results = query.getResultList();

		if (!results.isEmpty()) {
			return true;
		}

		return false;
		
	}
}
