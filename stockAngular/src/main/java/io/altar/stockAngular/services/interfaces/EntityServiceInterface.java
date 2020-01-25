package io.altar.stockAngular.services.interfaces;

import java.util.Collection;
import java.util.List;

import io.altar.stockAngular.models.Entity_;

public interface EntityServiceInterface<E extends Entity_> {

	E get(long id);

	List<Long> getAllIds();
	
	Collection<E> getAll();

	long create(E entity);

	void update(E entity);

	void delete(long id);
	
	long size();
}
