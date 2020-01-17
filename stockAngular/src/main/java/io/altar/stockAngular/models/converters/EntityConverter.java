package io.altar.stockAngular.models.converters;

public abstract class EntityConverter<E, D> {

	public abstract E toEntity(D dto);
	
	public abstract D toDTO(E entity);
}
