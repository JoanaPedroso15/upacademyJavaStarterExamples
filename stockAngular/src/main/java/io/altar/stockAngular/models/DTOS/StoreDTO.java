package io.altar.stockAngular.models.DTOS;

import java.util.ArrayList;
import java.util.List;

public class StoreDTO extends EntityDTO {

	private String name;
	private List<UserDTO> users = new ArrayList<UserDTO>();

	public StoreDTO() {
	}

	public StoreDTO(long id, String name, List<UserDTO> usersDTO) {
		this.id = id;
		this.name = name;
		this.users = usersDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
}
