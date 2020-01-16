package io.altar.stockAngular.models.converters;

import javax.enterprise.context.RequestScoped;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.DTOS.UserDTO;

@RequestScoped
public class UserConverter extends EntityConverter<User, UserDTO> {

	@Override
	public User toEntity(UserDTO dto) {
		User user = new User();
		if (dto.getId() > 0) {
			user.setId(dto.getId());
		}
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getEmail());
	}
}
