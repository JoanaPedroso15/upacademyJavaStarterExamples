package io.altar.stockAngular.models.converters;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.User.Role;
import io.altar.stockAngular.models.DTOS.UserDTO;
import io.altar.stockAngular.services.StoreService;

@RequestScoped
public class UserConverter extends EntityConverter<User, UserDTO> {

	@Inject
	StoreConverter converter;
	
	@Inject
	StoreService SS;
	
	@Override
	public User toEntity(UserDTO dto) {
		User user = new User();
		if (dto.getId() > 0) {
			user.setId(dto.getId());
		}
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setRole(Role.valueOf(dto.getRole()));
		user.setStores(dto.getStores()
				.stream()
				.map(storeDTO -> SS.get(storeDTO.getId()))
				.collect(Collectors.toSet()));
		System.out.println(user);
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getRole().name(),
				user.getStores().stream()
		        .map(store -> converter.toDTO(store))
		        .collect(Collectors.toList())
		);
	}
}
