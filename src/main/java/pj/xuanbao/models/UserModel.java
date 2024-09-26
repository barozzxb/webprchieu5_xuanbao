package pj.xuanbao.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String images;
	private String email;
	private String phone;
	private int roleid;
	private Date createddate;
	
	public UserModel() {
		super();
	}


	public UserModel(int id, String username, String password, String fullname, String images, String email,
			String phone, int roleid, Date createddate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createddate = createddate;
	}

	public UserModel(String username, String password, String fullname, String images, String email, String phone,
			int roleid, Date createddate) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createddate = createddate;
	}
	public UserModel(String username, String password, String fullname, String images, String email, String phone,
			int roleid) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
	}


	public UserModel(String username, String password, String fullname, String images, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.email = email;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getRoleid() {
		return roleid;
	}


	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", images=" + images + ", email=" + email + ", phone=" + phone + ", roleid=" + roleid
				+ ", createddate=" + createddate + "]";
	}
	
}
