package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Product;

@ApplicationScoped
public class ProductRepository extends EntityRepository<Product> {
	
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
}
