package pj.xuanbao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pj.xuanbao.configs.DBConnectMySQL;
import pj.xuanbao.dao.IUserDAO;
import pj.xuanbao.models.UserModel;

public class UserDAOImpl extends DBConnectMySQL implements IUserDAO{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = super.getDatabaseConnection(); //ket noi dtb
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//Add account vao list
			while (rs.next()) {
				list.add(new UserModel(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("fullname"),
						rs.getString("images"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getInt("roleid"),
						rs.getDate("createddate")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "insert into users(username, password, fullname, images, email, phone, roleid, createddate) values (?,?,?,?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreateddate());
			ps.executeUpdate();
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		String sql = "select * from users where email = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(!rs.next()) {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "select * from users where username = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			while(!rs.next()) {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String sql = "select * from users where phone = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			
			while(!rs.next()) {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void resetPassword(String email, String password) {
		String sql = "update users set password = ? where email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.executeUpdate();
			return;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IUserDAO dao = new UserDAOImpl();
		boolean email = dao.checkExistEmail("xuanbao@gmail.com");
		System.out.println(email);
		
		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		
		UserModel user = new UserModel("bao", "bao", "Bao Xuan", null, "bao@gmail.com", "0325647897", 2, date);
		dao.insert(user);
	}
}
