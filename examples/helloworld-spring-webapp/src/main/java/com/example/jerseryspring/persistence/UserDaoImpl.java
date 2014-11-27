package com.example.jerseryspring.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Qualifier("UserDaoImp")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User save(User entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public User findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return (List<User>)getSession().createCriteria(User.class).list();
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUserName(String username) {
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).setMaxResults(1).list();
		
	}
	
    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }


}
