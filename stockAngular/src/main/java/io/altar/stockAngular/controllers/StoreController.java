package io.altar.stockAngular.controllers;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.stockAngular.models.Store;
import io.altar.stockAngular.models.DTOS.StoreDTO;
import io.altar.stockAngular.models.converters.StoreConverter;
import io.altar.stockAngular.repositories.StoreRepository;
import io.altar.stockAngular.services.StoreService;

@RequestScoped
@Path("stores")
public class StoreController extends EntityController<StoreService, StoreRepository, StoreConverter, Store, StoreDTO> {

}
