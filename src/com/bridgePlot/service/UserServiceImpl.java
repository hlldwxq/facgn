package com.bridgePlot.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bridgePlot.dao.UserDAO;
import com.bridgePlot.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Resource private UserDAO uDao;

	@Override
	public User loginByNameAndPassword(String name, String password) {
		return uDao.getByNameAndPassword(name,password);
	}

	@Override
	public User loginByMailAndPassword(String mail, String password) {
		return uDao.getByMailAndPassword(mail, password);
	}

	@Override
	public void save(User user) {
		uDao.save(user);
	}

	@Override
	public void delete(int id) {
		uDao.deleteById(id);
	}
}
