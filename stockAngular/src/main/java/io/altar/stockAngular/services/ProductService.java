package io.altar.stockAngular.services;

import javax.enterprise.context.RequestScoped;

import io.altar.stockAngular.models.Product;
import io.altar.stockAngular.models.DTOS.ProductDTO;
import io.altar.stockAngular.repositories.ProductRepository;
import io.altar.stockAngular.services.interfaces.ProductServiceInterface;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product, ProductDTO> implements ProductServiceInterface {

	protected String getEntityClassName() {
		return Product.getClassName();
	}

	public boolean canDelete(Product product) {
		if (product.getShelves().size() > 0) {
			throw new UnsupportedOperationException(
					String.format("Product exist in [%d] shelves.",product.getShelves().size()));
		}
		return true;
	}
}
