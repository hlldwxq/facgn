package com.bridgePlot.service;

import com.bridgePlot.entity.User;

public interface UserService {
	
	User loginByNameAndPassword(String name,String password);
	User loginByMailAndPassword(String mail,String password);
	void save(User user);
	void delete(int id);
}
