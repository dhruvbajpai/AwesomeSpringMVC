package com.mindtree.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.dto.Point;
import com.mindtree.dto.User;

public class Dao {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public Dao()
	{
		
	}
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Point p1=new Point();
		Point p2=new Point();
		p1.setpId(1);
		p1.setLatitude(10);
		p1.setLongitude(10);
		p2.setpId(2);
		p2.setLatitude(100);
		p2.setLongitude(100);
		p1.setUser(user);
		p2.setUser(user);
		//user.getListPoints().add(p1);
		//user.getListPoints().add(p2);
		try {
			session.beginTransaction(); // can save as many objects as you want
										// using one transaction
			// transaction defines a single unit of work
			// group of objects can be saved in one transaction
			session.save(p1);
			session.save(p2);
			session.save(user);

			session.getTransaction().commit(); // end the transaction
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			// to undo things if things go wrong somewhere
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public  List<User> getUserByEmailAndPassword(String email, String password)  {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "FROM User U where U.userName= :email and U.password= :password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			session.getTransaction().commit();
			return (List<User>) query.getResultList();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

}
