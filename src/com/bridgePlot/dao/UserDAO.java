package com.bridgePlot.dao;

import com.bridgePlot.entity.User;

public interface UserDAO {
	//用户DAO
	User getByNameAndPassword(String name,String password);
	User getByMailAndPassword(String mail,String password);
	User getId(int id);
	void save(User u);
	void deleteById(int id);
}
