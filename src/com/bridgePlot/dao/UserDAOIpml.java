package com.bridgePlot.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bridgePlot.entity.User;


@Repository
public class UserDAOIpml implements UserDAO{
	//-------------------------------登录注册的时间还没有写-------------------------------
	
	@Resource private SessionFactory sessionFactory;
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User getByNameAndPassword(String name, String password) {
		User user = (User)this.currentSession().createQuery("from User where username = ? and password = ?")
			    	.setParameter(0,name).setParameter(1,password).uniqueResult();
		return user;
	}
	@Override
	public User getByMailAndPassword(String mail, String password) {
		User user = (User)this.currentSession().createQuery("from User where email = ? and password = ?")
		    	.setParameter(0,mail).setParameter(1,password).uniqueResult();
		return user;
	}
	@Override
	public User getId(int id) {
		User user = (User)this.currentSession().createQuery("from User where id = ?")
		    	.setParameter(0,id).uniqueResult();
		return user;
	}
	@Override
	public void save(User u) {
		this.currentSession().save(u);
	}
	@Override
	public void deleteById(int id) {
		currentSession().createQuery("delete User where id = ? ")
	    .setParameter(0,id).executeUpdate();

	}


}
