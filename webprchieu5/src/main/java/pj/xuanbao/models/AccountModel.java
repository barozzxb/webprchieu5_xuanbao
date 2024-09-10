package pj.xuanbao.models;

import java.io.Serializable;

public class AccountModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String dob;
	private String photo;
	public AccountModel() {
		super();
	}
	public AccountModel(String username, String password, String dob, String photo) {
		super();
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.photo = photo;
	}
	public AccountModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "AccountModel [username=" + username + ", password=" + password + ", dob=" + dob + ", photo=" + photo
				+ "]";
	}
	
	
}
