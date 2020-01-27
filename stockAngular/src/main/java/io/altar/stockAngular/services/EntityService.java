package io.altar.stockAngular.services;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.stockAngular.models.Entity_;
import io.altar.stockAngular.repositories.EntityRepository;
import io.altar.stockAngular.services.interfaces.EntityServiceInterface;

@Transactional
public abstract class EntityService<R extends EntityRepository<E>,E extends Entity_> implements EntityServiceInterface<E> {
	
	@Inject
	protected R repository;

	@Override
	public E get(long id) {
		return validEntity(id);
	}

	@Override
	public List<Long> getAllIds() {
		return repository.getAllIds();
	}
	
	@Override
	public Collection<E> getAll() {
		return repository.getAll();
	}

	@Override
	public long create(E entity) {
		return repository.addEntity(entity);
	}

	@Override
	public void update(E entity) {
		validEntity(entity.getId());
		repository.editEntity(entity);
	}

	@Override
	public void delete(long id) {
		canDelete(validEntity(id));
		repository.removeEntity(id);
	}
	
	@Override
	public long size() {
		return repository.size();
	}
	
	public E validEntity(long entityId) {
		E entity = repository.getEntity(entityId);
		if (entity == null) {
			throw new IllegalArgumentException(
					String.format("No %s with Id [%d].",getEntityClassName() ,entityId));
		}
		return entity;
	}
	
	protected abstract String getEntityClassName();
	
	protected abstract boolean canDelete(E entity);
}
