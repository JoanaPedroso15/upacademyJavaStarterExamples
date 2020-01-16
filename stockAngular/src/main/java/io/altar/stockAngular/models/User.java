package io.altar.stockAngular.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import io.altar.stockAngular.models.DTOS.UserDTO;

@Entity
@NamedQueries({ @NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u FROM User u"),
		@NamedQuery(name = User.GET_ALL_USERS_IDS, query = "SELECT u.id FROM User u"),
		@NamedQuery(name = User.GET_USERS_COUNT, query = "SELECT COUNT(u.id) FROM User u"),
		@NamedQuery(name = User.GET_USER_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email=:email") })
public class User extends Entity_<UserDTO> {

	public static final String GET_ALL_USERS = "getAllUsers";
	public static final String GET_ALL_USERS_IDS = "getAllUsersIds";
	public static final String GET_USERS_COUNT = "getUsersCount";
	public static final String GET_USER_BY_EMAIL = "getByEmail";

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	private String hashcode;
	private String salt;

	public static String getClassName() {
		return "User";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
