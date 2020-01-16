package io.altar.stockAngular.services.interfaces;

import java.util.Collection;
import java.util.List;

import io.altar.stockAngular.models.Entity_;
import io.altar.stockAngular.models.DTOS.EntityDTO;

public interface EntityServiceInterface<E extends Entity_<D>, D extends EntityDTO<E>> {

	E get(long id);

	List<Long> getAllIds();
	
	Collection<E> getAll();

	long create(E entity);

	void update(E entity);

	void delete(long id);
	
	long size();
}
