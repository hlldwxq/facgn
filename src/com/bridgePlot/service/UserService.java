package com.bridgePlot.service;

import com.bridgePlot.entity.User;

public interface UserService {
	
	User loginByNameAndPassword(String name,String password);
	User loginByMailAndPassword(String mail,String password);
	void save(User user);
	void updatePassword(String newPassword,int userId);
	void updateUserName(String userName,int userId);
	void delete(int id);
}
