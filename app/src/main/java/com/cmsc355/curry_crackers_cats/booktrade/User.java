package com.cmsc355.curry_crackers_cats.booktrade;
/**
 * 
 * @author Vishakha
 *Attributes: id, userName, password, email
 *Constructor: three parameter
 *Getter & Setters: all attributes
 */
public class User {

	// private variable
	int userId;
	String userName;
	String password;
	String email;

	public User () {
		this.userName = "";
		this.password = "";
		this.email = "";
	}
	public User(String username, String pass, String em){
		this.setUserName(username);
		this.setPassword(pass);
		this.setEmail(em);
	}

	/**
	 * @return the id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param id the id to set
	 */
	public void setUserId(int id) {
		this.userId = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		if (userName.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		if (password.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
		this.email = email;
	}
	
	
}
