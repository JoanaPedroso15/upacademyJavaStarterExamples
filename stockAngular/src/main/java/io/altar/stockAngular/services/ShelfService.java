package io.altar.stockAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.stockAngular.models.Shelf;
import io.altar.stockAngular.models.DTOS.ShelfDTO;
import io.altar.stockAngular.models.converters.ShelfConverter;
import io.altar.stockAngular.repositories.ShelfRepository;
import io.altar.stockAngular.services.interfaces.ShelfServiceInterface;

@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> implements ShelfServiceInterface {

	@Inject ShelfConverter converter;
	
	protected String getEntityClassName() {
		return Shelf.getClassName();
	}

	public boolean canDelete(Shelf shelf) {
		if (shelf.getProduct() != null) {
			throw new UnsupportedOperationException(
					String.format("Shelf have product with id [%d].", shelf.getProduct().getId()));
		}
		return true;
	}

	public List<Shelf> getEmptyShelves() {
		return repository.getEmptyShelves();
	}

	public List<ShelfDTO> findByProductId(long id) {
		return repository.findByProductId(id).stream().map(self -> converter.toDTO(self)).collect(Collectors.toList());
	}

	public void removeProductsByProductId(long id) {
		repository.removeProductsByProductId(id);
	}
}
