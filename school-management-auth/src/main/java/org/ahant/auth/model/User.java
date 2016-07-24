package org.ahant.auth.model;

import org.ahant.core.model.Person;

/**
 * Created by ahant on 3/19/2016.
 */
public class User extends Person {

	String userName;
	String password;
	Role role;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
