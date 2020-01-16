package io.altar.stockAngular.models.converters;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.stockAngular.models.Shelf;
import io.altar.stockAngular.models.DTOS.ShelfDTO;
import io.altar.stockAngular.services.ProductService;

@RequestScoped
public class ShelfConverter extends EntityConverter<Shelf, ShelfDTO> {

	@Inject
	ProductService PS;
	
	public Shelf toEntity(ShelfDTO selfDTO) {
		Shelf shelf = new Shelf();
		if (selfDTO.getId() > 0) {
			shelf.setId(selfDTO.getId());
		}
		shelf.setCapacity(selfDTO.getCapacity());
		shelf.setDailyPrice(selfDTO.getDailyPrice());
		shelf.setProduct(selfDTO.getProductId() > 0 ? PS.get(selfDTO.getProductId()) : null);
		return shelf;
	}
	
	public ShelfDTO toDTO(Shelf self) {
		return new ShelfDTO(
				self.getId(), 
				self.getCapacity(), 
				self.getDailyPrice(),
				(self.getProduct() == null) ? 0 : self.getProduct().getId());
	}
}
