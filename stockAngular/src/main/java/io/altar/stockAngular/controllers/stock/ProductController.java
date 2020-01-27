package io.altar.stockAngular.controllers.stock;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.stockAngular.controllers.EntityController;
import io.altar.stockAngular.models.Product;
import io.altar.stockAngular.models.DTOS.ProductDTO;
import io.altar.stockAngular.models.converters.ProductConverter;
import io.altar.stockAngular.repositories.ProductRepository;
import io.altar.stockAngular.services.ProductService;

@RequestScoped
@Path("products")
public class ProductController extends EntityController<ProductService, ProductRepository,ProductConverter , Product, ProductDTO> {

}
