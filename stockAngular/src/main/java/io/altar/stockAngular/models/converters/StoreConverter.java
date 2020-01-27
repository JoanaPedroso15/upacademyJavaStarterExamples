package io.altar.stockAngular.models.converters;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.stockAngular.models.Store;
import io.altar.stockAngular.models.DTOS.StoreDTO;
import io.altar.stockAngular.services.UserService;

@RequestScoped
public class StoreConverter extends EntityConverter<Store, StoreDTO> {

	@Inject
	UserConverter converter;
	
	@Inject
	UserService US;

	@Override
	public Store toEntity(StoreDTO dto) {
		Store store = new Store();
		if (dto.getId() > 0) {
			store.setId(dto.getId());
		}
		store.setName(dto.getName());
		store.setUsers(dto.getUsers()
				.stream()
				.map(userDTO -> US.get(userDTO.getId()))
				.collect(Collectors.toSet()));
		System.out.println(store);
		return store;
	}

	@Override
	public StoreDTO toDTO(Store store) {
		return new StoreDTO(
				store.getId(),
				store.getName(),
				store.getUsers()
					.stream()
					.map(user -> converter.toDTO(user))
					.collect(Collectors.toList())
		);
	}
}
