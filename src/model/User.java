package model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1133075533561417500L;
	private String username;
	private String password;
	private UserType type;
	private String email;
	public User(String username, String password, UserType type, String email, Sex sex, String firstname,
			String lastname, int id, String picture) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.email = email;
		this.sex = sex;
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.picture = picture;
	}

	private Sex sex;
	private String firstname;
	private String lastname;
	public User(String username, String password, UserType type, int id, String picture) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.id = id;
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private int id;
	private String picture;

	public String getUsername() {
		return username;
	}

	public User() {
	}

	public User(int id, String username, String password, UserType type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.id = id;
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

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
