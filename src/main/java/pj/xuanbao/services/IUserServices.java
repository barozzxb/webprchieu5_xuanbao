package pj.xuanbao.services;

import pj.xuanbao.models.UserModel;

public interface IUserServices {
	UserModel login(String username, String password);
	UserModel findByUsername(String username);
	boolean register(String email, String password, String username, String
			fullname, String phone);
	public boolean checkExistEmail(String email);
	public boolean checkExistUsername(String username);
	public boolean checkExistPhone(String phone);
	public void insert(UserModel user);
	
	public void resetPassword(String email, String password);
	
	public boolean update(UserModel user);
}
