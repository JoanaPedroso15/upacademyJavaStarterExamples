package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Shelf;

@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> {

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}
}