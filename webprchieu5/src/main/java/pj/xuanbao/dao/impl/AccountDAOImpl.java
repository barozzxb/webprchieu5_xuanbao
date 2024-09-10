package pj.xuanbao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pj.xuanbao.configs.DBConnectMySQL;
import pj.xuanbao.dao.IAccountDAO;
import pj.xuanbao.models.AccountModel;

public class AccountDAOImpl extends DBConnectMySQL implements IAccountDAO{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<AccountModel> findAll() {
		String sql = "select * from Account";
		
		List<AccountModel> list = new ArrayList<AccountModel>();
		try {
			conn = super.getDatabaseConnection(); //ket noi dtb
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//Add account vao list
			while (rs.next()) {
				list.add(new AccountModel(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("dob"),
						rs.getString("photo")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccountModel findByUsername(String username) {
		String sql = "select * from Account where username = '?'";
		
		AccountModel user = new AccountModel();
		try {
			conn = super.getDatabaseConnection(); //ket noi dtb
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setDob(rs.getString(3));
				user.setPhoto(rs.getString(4));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(AccountModel user) {
		String sql = "insert into Account(username, password, dob, photo) values (?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getDob());
			ps.setString(4, user.getPhoto());
			ps.execute();
			
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		AccountDAOImpl impl = new AccountDAOImpl();
		
		AccountModel user = impl.findByUsername("xuanbao");
		System.out.println(user.toString());
		//AccountModel user = new AccountModel("xuanbao", "xuanbao2004", "04/02/2004", "hisphoto");
		
		//impl.insert(user);
		
		//List<AccountModel> user1 = impl.findAll();
		
		//System.out.println(Arrays.toString(user1.toArray()));
	}
}
