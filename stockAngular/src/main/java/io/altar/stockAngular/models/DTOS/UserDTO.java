package io.altar.stockAngular.models.DTOS;

import io.altar.stockAngular.models.User;

public class UserDTO extends EntityDTO<User> {

	private String name;
	private String email;
	private String password;

	public UserDTO() {
	}

	public UserDTO(long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + ", id=" + id + "]";
	}

}
