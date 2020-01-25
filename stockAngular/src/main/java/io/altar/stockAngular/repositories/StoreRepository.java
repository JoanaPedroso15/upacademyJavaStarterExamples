package io.altar.stockAngular.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.stockAngular.models.Store;

@ApplicationScoped
public class StoreRepository extends EntityRepository<Store> {

	@Override
	protected Class<Store> getEntityClass() {
		return Store.class;
	}

	@Override
	protected String getAllEntities() {
		return Store.GET_ALL_STORES;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Store.GET_ALL_STORES_IDS;
	}

	@Override
	protected String getEntitiesCount() {
		return Store.GET_STORES_COUNT;
	}
}
