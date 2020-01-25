package io.altar.stockAngular.models.DTOS;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends EntityDTO {

	private String name;
	private String email;
	private String password;
	private String role;
	private List<StoreDTO> stores = new ArrayList<StoreDTO>();

	public UserDTO() {
	}

	public UserDTO(long id, String name, String email, String role, List<StoreDTO> stores) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.stores = stores;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<StoreDTO> getStores() {
		return stores;
	}

	public void setStores(List<StoreDTO> stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + ", id=" + id
				+ "]";
	}
}
