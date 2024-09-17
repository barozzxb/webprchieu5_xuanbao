package pj.xuanbao.dao;

import java.util.List;

import pj.xuanbao.models.UserModel;

public interface IUserDAO {

	List<UserModel> findAll();
	UserModel findByUsername(String username);
	void insert(UserModel user);
	
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
	void resetPassword(String email, String password);
}
