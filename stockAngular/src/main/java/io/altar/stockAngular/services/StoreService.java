package io.altar.stockAngular.services;

import javax.enterprise.context.RequestScoped;

import io.altar.stockAngular.models.Store;
import io.altar.stockAngular.repositories.StoreRepository;

@RequestScoped
public class StoreService extends EntityService<StoreRepository, Store> {

	@Override
	protected String getEntityClassName() {
		return Store.getClassName();
	}

	@Override
	protected boolean canDelete(Store entity) {
		return true;
	}
}
