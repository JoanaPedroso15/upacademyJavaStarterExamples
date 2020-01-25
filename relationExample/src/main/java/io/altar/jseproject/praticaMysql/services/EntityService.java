package io.altar.jseproject.praticaMysql.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.jseproject.praticaMysql.models.Entity_;
import io.altar.jseproject.praticaMysql.repositories.EntityRepository;

@Transactional
public abstract class EntityService<R extends EntityRepository<E>,E extends Entity_> {
	
	@Inject
	protected R repository;

	public E get(long id) {
		return repository.getEntity(id);
	}

	public E create(E entity) {
		return repository.addEntity(entity);
	}

	public void update(E entity) {
		repository.editEntity(entity);
	}

	public void delete(long id) {
		repository.removeEntity(id);
	}	
}
