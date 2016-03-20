package org.ahant.model.login;

/**
 * Created by ahant on 3/19/2016.
 */
public class User {

	String userName;
	String password;

	public User(String userName, String password) {
		setUserName(userName);
		setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
