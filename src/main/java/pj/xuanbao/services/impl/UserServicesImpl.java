package pj.xuanbao.services.impl;

import pj.xuanbao.dao.IUserDAO;
import pj.xuanbao.dao.impl.UserDAOImpl;
import pj.xuanbao.models.UserModel;
import pj.xuanbao.services.IUserServices;

public class UserServicesImpl implements IUserServices{


	IUserDAO userDAO = new UserDAOImpl();
	
	@Override
	public void resetPassword(String email, String password) {
		userDAO.resetPassword(email, password);
	}

	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDAO.checkExistUsername(username)) {
			return false;
		}
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDAO.insert(new UserModel(username, password, fullname, null, email, phone, 2, date));
		return true;
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		return userDAO.checkExistEmail(email);
	}
	
	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
	}
	@Override
	public boolean checkExistPhone(String phone) {
		return userDAO.checkExistPhone(phone);
	}
	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
	}

	public static void main(String[] args) {
		IUserServices service = new UserServicesImpl();
		UserModel user = service.login("xbao", "xbao");
		System.out.println(user.toString());
	}
}
